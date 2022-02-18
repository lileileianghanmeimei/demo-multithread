package com.example.java8;

public class StringTest {
    public static void main(String[] args) {
        String name1 = "limei";
        String name2 = "limei";
        System.out.println(name1==name2); //结果为true

        String name3 = new String("limei");
        String name4 = new String("limei");
        System.out.println(name3==name4); //false
    }
}
