package dev.bank.bankstatement;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

import dev.bank.bankstatement.data.BankStatementCSVParser;
import dev.bank.bankstatement.data.BankStatementParser;
import dev.bank.bankstatement.model.BankTransaction;
import dev.bank.bankstatement.service.BankStatementProcessor;

// BankStatement2에서 구현한 내용(참고용)
public class BankStatementAnalyzerWithParserInterface {
    private static final String RESOURCES = "src/main/resources/";
    
    public static void main(String[] args) throws IOException {

        // 파일 입출력
        final Path path = Paths.get(RESOURCES + "bank-data-simple.csv");
        final List<String> lines = Files.readAllLines(path); // Ctrl + .

        // 데이터 파싱
        // 인터페이스도 하나의 타입이다.
        // before applying interface(인터페이스 적용 전)
        // BankStatementTSVParser bankStatementTSVParser = new BankStatementTSVParser();
        // BankStatementCSVParser bankStatementParser = new BankStatementCSVParser();

        // After applying interface(인터페이스 적용 후)
        BankStatementParser bankStatementParser = new BankStatementCSVParser();
        
        // bankStatementTSVParser.parseLinesFromTSV(lines);
        List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);

        // 입출금 내역 연산
        BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

        // 입출금 내역 결과 출력
        collectSummary(bankStatementProcessor);
        
    }

    private static void collectSummary(BankStatementProcessor bankStatementProcessor) {
        System.out.println("총 입출금 내역은 " + bankStatementProcessor.calculateTotalAmount() + "입니다");

        System.out.println("1월의 입출금 내역은 "+ bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));

        System.out.println("Salary(급여) 카테고리의 내역은 : " + bankStatementProcessor.calculateTotalForCategory("Salary"));
    }
}
