package com.demo.activity;

import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.demo.controllers.OnErrorCallBack;
import com.demo.controllers.RecipesController;
import com.demo.models.Recipe;
import com.demo.models.RecipesHolder;
import com.demo.repos.BaseNetworkRepository;
import com.demo.repos.RecipesRepo;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static com.facebook.common.internal.ByteStreams.copy;

public class RecipeListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecipesController recipesController;
    GridLayoutManager staggeredGridLayoutManager;
    List<Recipe> recipes= new ArrayList<>();
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);
        recyclerView = findViewById(R.id.recyclerView);
        progressBar = findViewById(R.id.progressBar);

        recipesController = new RecipesController(new RecipesRepo(new BaseNetworkRepository()));

        recipesController.SetLiseners(this, new Observer<List<Recipe>>() {
            @Override
            public void onChanged(@Nullable List<Recipe> recipes) {
                RecipeListActivity.this.recipes = recipes;
                progressBar.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);
            }
        });
        recyclerView.setVisibility(View.GONE);

        staggeredGridLayoutManager = new GridLayoutManager(this,
                2);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setAdapter(new RecyclerView.Adapter() {
            @NonNull
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
                RecipeHolder holder =  new RecipeHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recipes_row_item,viewGroup,false));
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        RecipeListActivity.this.onClick(v);
                    }
                });
                return holder;
            }

            @Override
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
                RecipeHolder holder = (RecipeHolder) viewHolder;
                Recipe rep = recipes.get(i);
                Glide.with(RecipeListActivity.this).load(rep.getImage_url()).into(holder.imageView);
                holder.textView.setText(rep.getTitle());
            }

            @Override
            public int getItemCount() {
                return recipes.size();
            }
        });

        recipesController.getRecpies(new OnErrorCallBack() {
            @Override
            public void error(String error, int code) {
                Toast.makeText(RecipeListActivity.this,error,Toast.LENGTH_LONG).show();
            }
        });

    }

    private void onClick(View view)
    {
        int pos = recyclerView.getChildAdapterPosition(view);
        Recipe recipe = recipes.get(pos);
        Intent intent = new Intent(this,RecipesDetailsActivity.class);
        intent.putExtra(RecipesDetailsActivity.KEY,recipe.getRecipe_id());
        startActivity(intent);
    }

    class RecipeHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        RecipeHolder(final View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.name);
            imageView = itemView.findViewById(R.id.food);
        }
    }


}
