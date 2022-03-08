package com.example.collection;

import org.junit.Test;

import java.util.ArrayList;

public class ArrayListTest {
    @Test
    public void test() {
        ArrayList al = new ArrayList();
        al.add(1);
        al.add(null);
        al.add("string");
        al.add("limei");


        System.out.println(al.toString());
        al.remove(null);
        System.out.println(al.toString());
        //System.out.println(al.indexOf("limei"));
        //System.out.println(al.lastIndexOf("limei"));
       //System.out.println(al.contains("limei"));


    }
}
