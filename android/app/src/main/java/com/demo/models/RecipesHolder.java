package com.demo.models;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
/**
 * Awesome Pojo Generator
 * */
public class RecipesHolder {
  @SerializedName("recipes")
  public List<Recipe> recipes;
}