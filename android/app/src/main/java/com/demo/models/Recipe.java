package com.demo.models;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class Recipe{
  @SerializedName("social_rank")
  @Expose
  private Integer social_rank;
  @SerializedName("f2f_url")
  @Expose
  private String f2f_url;
  @SerializedName("recipe_id")
  @Expose
  private String recipe_id;
  @SerializedName("publisher_url")
  @Expose
  private String publisher_url;
  @SerializedName("image_url")
  @Expose
  private String image_url;
  @SerializedName("publisher")
  @Expose
  private String publisher;
  @SerializedName("title")
  @Expose
  private String title;
  @SerializedName("source_url")
  @Expose
  private String source_url;
  public void setSocial_rank(Integer social_rank){
   this.social_rank=social_rank;
  }
  public Integer getSocial_rank(){
   return social_rank;
  }
  public void setF2f_url(String f2f_url){
   this.f2f_url=f2f_url;
  }
  public String getF2f_url(){
   return f2f_url;
  }
  public void setRecipe_id(String recipe_id){
   this.recipe_id=recipe_id;
  }
  public String getRecipe_id(){
   return recipe_id;
  }
  public void setPublisher_url(String publisher_url){
   this.publisher_url=publisher_url;
  }
  public String getPublisher_url(){
   return publisher_url;
  }
  public void setImage_url(String image_url){
   this.image_url=image_url;
  }
  public String getImage_url(){
   return image_url;
  }
  public void setPublisher(String publisher){
   this.publisher=publisher;
  }
  public String getPublisher(){
   return publisher;
  }
  public void setTitle(String title){
   this.title=title;
  }
  public String getTitle(){
   return title;
  }
  public void setSource_url(String source_url){
   this.source_url=source_url;
  }
  public String getSource_url(){
   return source_url;
  }
}