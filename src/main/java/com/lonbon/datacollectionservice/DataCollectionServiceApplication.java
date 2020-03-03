package com.lonbon.datacollectionservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = {"com.lonbon.datacollectionservice"})
@MapperScan("com.lonbon.datacollectionservice.dao")
@ServletComponentScan
@EnableTransactionManagement
public class DataCollectionServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataCollectionServiceApplication.class, args);
    }

}
