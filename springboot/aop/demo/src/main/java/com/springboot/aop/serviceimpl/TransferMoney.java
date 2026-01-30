package com.springboot.aop.serviceimpl;

import org.springframework.stereotype.Component;

@Component
public class TransferMoney {

    public void transferMoney(){
        System.out.println("money is being transfered");
    }

}
