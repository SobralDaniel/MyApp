package com.example.nbacademy.myapp;

import android.app.Application;
import android.test.ApplicationTestCase;

import com.example.nbacademy.myapp.database.MainActivity;
import com.example.nbacademy.myapp.database.MockupData;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    public void testCreate(){
        MainActivity mainAct = new MainActivity();
        MockupData mockupData = new MockupData(mainAct);
        mockupData.getUser();
    }
}