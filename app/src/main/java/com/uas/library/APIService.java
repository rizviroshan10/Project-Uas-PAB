package com.uas.library;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIService {
    @GET("post")
    Call<ValueData<List<Post>>> getPost();

    @FormUrlEncoded
    @POST("auth/login")
    Call<ValueData<User>> login(
                          @Field("username") String username,
                          @Field("password") String password);


    @FormUrlEncoded
    @POST("auth/register")
    Call<ValueData<User>> register(
                             @Field("username") String username,
                             @Field("password") String password);

    @FormUrlEncoded
    @POST("post")
    Call<ValueNoData> addPost(
            @Field("userId") String userId,
            @Field("foto") String foto,
            @Field("judul") String judul,
            @Field("deskripsi") String deskripsi,
            @Field("karya") String karya );

    @FormUrlEncoded
    @POST("post")
    Call<ValueNoData> updatePost(@Field("id") String id,
                              @Field("content") String content);

    @FormUrlEncoded
    @POST("post/{id}")
    Call<ValueNoData> deletePost(@Field("id") String id);
}
