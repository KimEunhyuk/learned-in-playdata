package dev.bank.bankstatement;

import java.io.IOException;

public class MainApplication {
    
    public static void main(String[] args) throws IOException {

        // 두줄 주석(before)
        // BankStatementParser bankStatementParser = new BankStatementCSVParser();
        // BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer(bankStatementParser);     

        // BankStatementParser bankStatementParser = new BankStatementCSVParser();
        // or new BankStatementTSVParser();

        // (after)
        BackStatementFactory backStatementFactory = new BackStatementFactory();
        
        BankStatementAnalyzer bankStatementAnalyzer =  backStatementFactory.bankStatementAnalyzer();     


        bankStatementAnalyzer.analyze("bank-data-simple.csv");
    }
}