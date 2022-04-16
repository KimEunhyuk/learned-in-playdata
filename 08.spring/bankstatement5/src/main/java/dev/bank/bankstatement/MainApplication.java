package dev.bank.bankstatement;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApplication {
    
    public static void main(String[] args) throws IOException {

        // Before Factory
        // BankStatementParser bankStatementParser = new BankStatementCSVParser();
        // BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer(bankStatementParser);     

        // BankStatementParser bankStatementParser = new BankStatementCSVParser();
        // or new BankStatementTSVParser();

        // After Factory
        // BackStatementFactory backStatementFactory = new BackStatementFactory();
        
        // BankStatementAnalyzer bankStatementAnalyzer =  backStatementFactory.bankStatementAnalyzer();     
        
        // After spring
        final ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BankStatementFactory.class);

        BankStatementAnalyzer bankStatementAnalyzer = applicationContext.getBean(BankStatementAnalyzer.class);


        bankStatementAnalyzer.analyze("bank-data-simple.csv");
    }
}