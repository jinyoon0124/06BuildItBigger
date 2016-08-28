/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.example.myapplication.backend;

import com.example.JokeTeller;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

/** An endpoint class we are exposing */
//@Api(
//  name = "jokeTellerApi",
//  version = "v1",
//  namespace = @ApiNamespace(
//    ownerDomain = "backend.myapplication.example.com",
//    ownerName = "backend.myapplication.example.com",
//    packagePath=""
//  )
//)
//public class MyEndpoint {
//
//    /** A simple endpoint method that takes a name and says Hi back */
//    @ApiMethod(name = "tellJoke")
//    public JokeTeller tellJoke(@Named("joke") String joke) {
//        JokeTeller response = new JokeTeller();
//        response.setJokeString("Created !!!!"+joke);
//        return response;
//    }
//
//}

@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.myapplication.example.com",
                ownerName = "backend.myapplication.example.com",
                packagePath=""
        )
)
public class MyEndpoint {

    /** A simple endpoint method that takes a name and says Hi back */
    @ApiMethod(name = "jokeCreate")
    public MyBean jokeCreate(@Named("index") int i) {
        JokeTeller jokeTeller = new JokeTeller();
        MyBean response = new MyBean();
        response.setData(jokeTeller.tellJoke(i));

        return response;
    }

}