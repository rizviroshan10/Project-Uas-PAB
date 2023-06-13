package com.uas.library;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface APIService {
    @POST("post")
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
    Call<ValueData<Post>> addPost(
            @Field("user_id") String user_id,
            @Field("judul") String judul,
            @Field("content") String content,
            @Field("foto") String foto,
            @Field("jumlah") int jumlah);



    @FormUrlEncoded
    @PUT("post")
    Call<<ValueData<Post>> updatePost(@Field("id") String id,
                                 @Field("foto") String foto,
                                 @Field("judul") String judul,
                                 @Field("content") String content,
                                 @Field("jumlah") int jumlah);


    @DELETE("post/{id}")
    Call<<ValueData<Post>> deletePost(@Field("id") String id);
}
