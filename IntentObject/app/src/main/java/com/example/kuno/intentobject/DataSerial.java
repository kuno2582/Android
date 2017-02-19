package com.example.kuno.intentobject;

import java.io.Serializable;

/**
 * Created by kuno on 2017-02-01.
 */

public class DataSerial implements Serializable {

    String name;
    int age;
    String address;

    public DataSerial(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

}
