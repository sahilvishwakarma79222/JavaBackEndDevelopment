package com.springboot.aop.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransferMoneyAspect {

//    @Before("execution(* com.springboot.aop.serviceimpl.TransferMoney.transferMoney())")
//    public void beforeTransferMoney() {
//        System.out.println("Logging before transferring money");
//    }


//        @After("execution(* com.springboot.aop.serviceimpl.TransferMoney.transferMoney())")
//    public void beforeTransferMoney() {
//        System.out.println("Logging after transferring money");
//    }

    @Around("execution(* com.springboot.aop.serviceimpl.TransferMoney.transferMoney())")
    public void beforeTransferMoney() {
        System.out.println("Logging =======================   transferring money");
    }
}
