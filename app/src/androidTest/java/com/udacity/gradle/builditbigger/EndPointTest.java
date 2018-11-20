package com.udacity.gradle.builditbigger;


import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.assertNotEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

@RunWith(AndroidJUnit4.class)
public class EndPointTest implements EndpointsAsyncTask.EndpointsAsyncTaskInterface {

    CountDownLatch latch;

    @Test
    public void testEndPointTask() throws InterruptedException {
        latch = new CountDownLatch(1);
        EndpointsAsyncTask testTask = new EndpointsAsyncTask(this);
        testTask.execute();
        latch.await();
    }

    @Override
    public void onDataLoaded(String result) {
        assertNotNull(result);
        assertNotEquals("", result);
        Log.d("EndpointsAsyncTask", result);
        latch.countDown();
    }
}
