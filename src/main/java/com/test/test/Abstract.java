package com.test.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: dchauhan
 * Date: 4/18/17.
 */
public abstract class Abstract {
    protected List<String> data;

    protected void initMap(String c){
        if(data == null){
            data = new ArrayList<String>();
        }
        data.add(AbsData.getValue(c));
    }

    protected List<String> getData(){
        return data;
    }
}
