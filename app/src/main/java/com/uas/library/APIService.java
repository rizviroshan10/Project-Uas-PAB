package com.uas.library;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;


import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface APIService {

    @GET("post")
    Call<ValueData<List<Post>>> getPost();


    @FormUrlEncoded
    @POST("auth/login")
    Call<ValueData<User>> login(
            @Field("username")String username,
            @Field("password")String password);

    @FormUrlEncoded
    @POST("auth/register")
    Call<ValueData<User>> register(
            @Field("username")String username,
            @Field("password")String password);

    @FormUrlEncoded
    @POST("post")
    Call<ValueNoData> addPost(
            @Field("user_id") String UserId,
            @Field("judul") String judul,
            @Field("content") String content,
            @Field("jumlah") String jumlah,
            @Field("sampul") String sampul);

    @FormUrlEncoded
    @PUT("post")
    Call<ValueNoData> updatePost(
                                 @Field("id") String id,
                                 @Field("content") String content,
                                 @Field("jumlah") String jumlah);


    @DELETE("post/{id}")
    Call<ValueNoData> deletePost(@Path("id") String id);
}
