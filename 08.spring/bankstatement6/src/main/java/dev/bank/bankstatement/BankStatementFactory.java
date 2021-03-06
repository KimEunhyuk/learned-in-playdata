package dev.bank.bankstatement;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import dev.bank.bankstatement.data.BankStatementCSVParser;

@Configuration // 이 클래스가 빈 구성정보로 활용할 수 있도록 지정
@ComponentScan
public class BankStatementFactory {

    // <context:component-scan basc-package="dev.bank.bankstatement"/>

    // <beans>
    //      <bean id="bankstatementparser">
    // </beans>

    // 
    // @Bean
    // public BankStatementCSVParser bankStatementCSVParser(){
    //     return new BankStatementCSVParser();
    // }

    // 빈 구성 정보 내 등록되어 있는 빈
    // @Bean
    // public BankStatementAnalyzer bankStatementAnalyzer(BankStatementCSVParser bankStatementCSVParser){
    //     BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer(bankStatementCSVParser);

    //     return bankStatementAnalyzer;
    // }
}
