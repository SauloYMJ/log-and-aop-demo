package com.ymj.entity;

/**
 * 学生实体类
 */
public class Student {
    private Integer age;
    private String name;

    public Student(Integer age, String name){
        this.age = age;
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    public Integer getAge() {
        System.out.println("Age : " + age );
        return age;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        System.out.println("Name : " + name );
        return name;
    }
}
