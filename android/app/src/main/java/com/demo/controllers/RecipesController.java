package com.demo.controllers;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;

import com.demo.models.Recipe;
import com.demo.repos.RecipesRepo;
import com.demo.repos.RepoCallBack;

import java.util.List;

public class RecipesController {

    private RecipesRepo recipesRepo;
    private MutableLiveData<List<Recipe>> liveDataA = new MutableLiveData<>();


    public RecipesController(RecipesRepo recipesRepo)
    {
        this.recipesRepo = recipesRepo;
    }
    public void SetLiseners(LifecycleOwner owner, Observer<List<Recipe>> observer)
    {
        liveDataA.observe(owner, observer);
    }
    public void getRecpies(OnErrorCallBack onErrorCallBack)
    {
        recipesRepo.GetDashboard(new RepoCallBack<List<Recipe>>() {
            @Override
            public void RepoResult(List<Recipe> data, String error, int code) {
                if(data != null)
                {
                    liveDataA.postValue(data);
                }
                else
                {

                }
            }
        });
    }

}
