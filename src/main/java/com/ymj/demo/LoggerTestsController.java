package com.ymj.demo;

import com.ymj.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * controller
 * @author ymj
 */
@RestController
public class LoggerTestsController {
    private final Logger logger = LoggerFactory.getLogger(LoggerTestsController.class);

    @RequestMapping("/test1")
    public String test1(){
        String name="yinmingjun";
        String password="123";
        logger.info("info级别日志，name:{}, password:{}",name,password);
        logger.error("error级别日志，test1 error message!");

        Student student = new Student(14, "yinmingjun");
        student.getName();
        student.getAge();

        return "test1 success";
    }

    @RequestMapping("/test2")
    public String test2(){
        String name="yinyifan";
        String password="456";
        logger.info("info级别日志，name:{}, password:{}",name,password);
        logger.error("error级别日志，test2 error message!");

        Student student = new Student(14, "yinmingjun");
        student.getName();
        student.getAge();

        return "test2 success";
    }


}
