package com.demo.repos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Modifier;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseNetworkRepository {

    //don't do this in production
    protected String APIKEY = "5e3af3fd8175a49108c8227793ab0044";

    public Object ServiceConstructor(Class ServiceToCon)
    {
        // HttpLoggingInterceptor logging = new HttpLoggingInterceptor();

// set your desired log level
        /// logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        // OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
// add your other interceptors …
// add logging as last interceptor

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.food2fork.com/api/")
                .addConverterFactory(GsonConverterFactory.create(getGsonConverter()))
                //.client(httpClient.build())
                .build();

        return retrofit.create(ServiceToCon);

    }

    public Gson getGsonConverter() {
        GsonBuilder b = new GsonBuilder();
        Gson gson = b.excludeFieldsWithModifiers(Modifier.PROTECTED).create();
        return gson;
    }

}
