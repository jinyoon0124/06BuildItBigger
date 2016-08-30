package com.udacity.gradle.builditbigger;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.util.Pair;
import android.widget.Toast;

import com.example.joketelleractivity.JokeActivity;
import com.example.myapplication.backend.myApi.MyApi;
//import com.example.myapplication.backend.jokeTellerApi.JokeTellerApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

/**
 * Created by Jin Yoon on 8/26/2016.
 */
class EndpointsAsyncTask extends AsyncTask<Pair<Context, Integer>, Void, String> {
//    private static JokeTellerApi myApiService = null;
    private static MyApi myApiService = null;
    private Context context;
    private ProgressDialog progressDialog;
    private JokeAsyncTaskListener mListener = null;
    private Exception mError = null;

    public EndpointsAsyncTask(Context context) {
        this.context = context;
    }

//    public EndpointsAsyncTask(){
//        context = null;
//    }
    public EndpointsAsyncTask setListener(JokeAsyncTaskListener listener){
        this.mListener = listener;
        return this;
    }

    @Override
    protected void onPreExecute() {
        if(context!=null){
            progressDialog = new ProgressDialog(context);
            progressDialog.setTitle("Please wait");
            progressDialog.setMessage("Loading..");
            progressDialog.show();
        }

    }

    @Override
    protected void onCancelled() {
        if(this.mListener != null){
            mError = new InterruptedException("AsyncTask cancelled");
            this.mListener.onComplete(null, mError);
        }
    }

    @Override
    protected String doInBackground(Pair<Context, Integer>... params) {
        if(myApiService == null) {  // Only do this once
//            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
//                    new AndroidJsonFactory(), null)
//                    // options for running against local devappserver
//                    // - 10.0.2.2 is localhost's IP address in Android emulator
//                    // - turn off compression when running against local devappserver
//                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
//                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
//                        @Override
//                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
//                            abstractGoogleClientRequest.setDisableGZipContent(true);
//                        }
//                    });
            // end options for devappserver

//            JokeTellerApi.Builder builder = new JokeTellerApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
//                    .setRootUrl("https://builditbigger-141507.appspot.com/_ah/api/");


            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://builditbigger-141507.appspot.com/_ah/api/");

            myApiService = builder.build();
        }

        context = params[0].first;
        int index = params[0].second;

        try {
//            return myApiService.tellJoke(joke).execute().getJokeString();
            return myApiService.jokeCreate(index).execute().getData();
        } catch (IOException e) {
            mError = e;
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
//        Toast.makeText(context, result, Toast.LENGTH_LONG).show();
//        progressDialog.dismiss();
        if(this.mListener !=null){
            this.mListener.onComplete(result, mError);
        }

//        Toast.makeText(context, result, Toast.LENGTH_LONG).show();
        Log.v("AYNC RESULT STRING", result);
        if(context!=null){
            Intent intent = new Intent(context, JokeActivity.class);
            intent.putExtra("JOKE", result);
            context.startActivity(intent);
        }

    }

    public static interface JokeAsyncTaskListener{
        public void onComplete(String joke, Exception e);

    }
}
