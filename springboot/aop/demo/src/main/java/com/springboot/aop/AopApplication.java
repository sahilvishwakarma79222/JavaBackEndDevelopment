package com.springboot.aop;

import com.springboot.aop.serviceimpl.TransferMoney;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AopApplication {

	public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(AopApplication.class, args);
        TransferMoney transferMoney = context.getBean("transferMoney", TransferMoney.class);
        transferMoney.transferMoney();

    }

}
