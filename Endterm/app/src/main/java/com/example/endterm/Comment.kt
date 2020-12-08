package com.example.endterm

import com.google.gson.annotations.SerializedName

data class Comment(
        var name: String,
        @SerializedName("name")
        var id: Int,
        @SerializedName("body")
        var body: String,
        @SerializedName("postId")
        var postId: Int
)