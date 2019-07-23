package com.demo.service;

import com.demo.models.RecipesHolder;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface RecipesService {
    @Headers({"Content-Type: application/json" ,  "Accept: application/json"})
    @GET
    Call<RecipesHolder> GetRecipes(@Url String url , @Query("key") String key);

}
