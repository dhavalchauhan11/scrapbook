package com.test.test;

import java.util.List;

/**
 * Author: dchauhan
 * Date: 4/18/17.
 */
public class AbsClass2 extends Abstract {
    public static void main(String[] args) {
        AbsClass2 class1 = new AbsClass2();
        class1.doWork();
        class1.print();
    }

    public void doWork(){
        initMap("class2");
    }

    public void print(){
        List<String> data = getData();
        System.out.println(data);
    }
}
