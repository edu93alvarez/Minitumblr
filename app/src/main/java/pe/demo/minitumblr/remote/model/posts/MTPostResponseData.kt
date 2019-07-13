package pe.demo.minitumblr.remote.model.posts

import com.google.gson.annotations.SerializedName

class MTPostResponseData(
    @SerializedName("posts")
    val posts: List<MTPostRemoteModel>? = null
)