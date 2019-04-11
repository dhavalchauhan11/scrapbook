package com.test.test;

import java.util.List;

/**
 * Author: dchauhan
 * Date: 4/18/17.
 */
public class AbsClass1 extends Abstract{


    public void doWork(){
        initMap("class1");
    }

    public void print(){
        List<String> data = getData();
        System.out.println(data);
    }

    public static void main(String[] args) {
        System.out.println("printing...");
        AbsClass1 class1 = new AbsClass1();
        class1.doWork();
        class1.print();
    }


}


