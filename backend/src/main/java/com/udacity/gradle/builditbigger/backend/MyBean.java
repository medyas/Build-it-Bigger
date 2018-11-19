package com.udacity.gradle.builditbigger.backend;

import ml.medyas.jokeslibrary.JokesClass;

/** The object model for the data we are sending through endpoints */
public class MyBean {

    private String myData;

    public MyBean() {
    }

    public String getData() {
        return myData;
    }

    public void setData(String data) {
        myData = data;
    }
}