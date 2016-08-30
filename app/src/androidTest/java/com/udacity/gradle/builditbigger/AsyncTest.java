package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.content.Context;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.ApplicationTestCase;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Jin Yoon on 8/29/2016.
 */
public class AsyncTest extends ApplicationTestCase<Application> {
    String mJokeString = null;
    Exception mError = null;
    CountDownLatch signal = null;



    public AsyncTest() {
        super(Application.class);

    }


    @Override
    protected void setUp() throws Exception {

        signal = new CountDownLatch(1);
    }

    @Override
    protected void tearDown() throws Exception {
        signal.countDown();
    }

    public void testJokeRetriever() throws InterruptedException {
        EndpointsAsyncTask task = new EndpointsAsyncTask(getSystemContext());
        Random rand = new Random();
        int i = rand.nextInt(5);
        task.setListener(new EndpointsAsyncTask.JokeAsyncTaskListener() {
            @Override
            public void onComplete(String joke, Exception e) {
                mJokeString = joke;
                mError = e;
                signal.countDown();
            }
        }).execute(new Pair<>(getSystemContext(), i));
        signal.await();

//        assertNotNull(mError);
//        Log.v("TEST STRING FROM TEST", mJokeString);

        assertFalse(TextUtils.isEmpty(mJokeString));
        assertFalse(mJokeString.contains("503 Service Unavailable"));
//        assertTrue(!mJokeString.contains("503 Service Unavailable")
//            && !TextUtils.isEmpty(mJokeString));

    }
}
