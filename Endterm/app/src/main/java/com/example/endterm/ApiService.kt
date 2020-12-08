package com.example.endterm

import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("posts")
    fun getAllPosts(): Call<MutableList<Post>>

    @GET("comments")
    fun getAllComments(): Call<MutableList<Comment>>

    @GET("posts/{id}/")
    fun getTodoById(@Path("id") postId: Int?): Call<Post>

    @FormUrlEncoded
    @POST("todos")
    fun addTodo(
            @Field("title") title: String,
            @Field("body") body: String
    ): Call<Post>

    @GET("posts/{id}/")
    fun getUser(@Path("id") postId: Int): Call<Post>

    @GET("comments/{id}")
    fun getCommentById(@Path("postId")commentId: Int): Call<Comment>

}