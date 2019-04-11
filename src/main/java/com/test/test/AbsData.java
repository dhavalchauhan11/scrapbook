package com.test.test;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: dchauhan
 * Date: 4/18/17.
 */
public class AbsData {

    static Map<String,String> dataMap;

    static {
        dataMap = new HashMap<String, String>();
        dataMap.put("class1","value1");
        dataMap.put("class3","value3");
        dataMap.put("class5","value5");

        dataMap.put("class2","value2");
        dataMap.put("class4","value4");
        dataMap.put("class6","value6");
    }

    public static String getValue(String key){
        return dataMap.get(key);
    }
}
