package com.ymj.demo;

import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 一个优先级较高的切面
 * @author ymj
 */
@Component
@Aspect
@Order(1)
public class AnotherLogging {
    private final Logger logger = LoggerFactory.getLogger(AnotherLogging.class);

    //基于类实现
    //@Pointcut("execution(* com.ymj.demo.*.*(..))")
    //基于方法实现
    @Pointcut("execution(public String com.ymj.demo.LoggerTestsController.test2())")
    private void selectAll(){}

    @Before("selectAll()")
    public void beforeAdvice1(){
        logger.info("highest_precedence before selectAll");
    }

    @After("selectAll()")
    public void afterAdvice(){
        logger.info("highest_precedence after selectAll");
    }

    @AfterReturning(pointcut = "selectAll()", returning="retVal")
    public void afterReturningAdvice(Object retVal){
        logger.info("highest_precedence Returning:{}", retVal.toString() );
    }
}
