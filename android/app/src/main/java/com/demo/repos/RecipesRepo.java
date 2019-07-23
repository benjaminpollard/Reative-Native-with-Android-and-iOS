package com.demo.repos;

import com.demo.models.Recipe;
import com.demo.models.RecipesHolder;
import com.demo.service.RecipesService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecipesRepo{

    private BaseNetworkRepository serviceCon;

    public RecipesRepo(BaseNetworkRepository serviceCon)
    {
        this.serviceCon = serviceCon;
    }

    public void GetDashboard( final RepoCallBack<List<Recipe>> callback) {
        final RecipesService service = (RecipesService) serviceCon.ServiceConstructor(RecipesService.class);

        service.GetRecipes("search",serviceCon.APIKEY).enqueue(new Callback<RecipesHolder>() {
            @Override
            public void onResponse(Call<RecipesHolder> call, Response<RecipesHolder> response) {
                if(response.isSuccessful())
                {
                    callback.RepoResult(response.body().recipes,"",0);
                }
                else
                {
                    callback.RepoResult(null,"error",0);
                }
            }

            @Override
            public void onFailure(Call<RecipesHolder> call, Throwable t) {
                callback.RepoResult(null,"error",0);
            }
        });

    }
}
