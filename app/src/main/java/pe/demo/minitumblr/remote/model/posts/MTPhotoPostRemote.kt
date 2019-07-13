package pe.demo.minitumblr.remote.model.posts

import com.google.gson.annotations.SerializedName

class MTPhotoPostRemote(
    @SerializedName("caption")
    var caption: String? = null,
    @SerializedName("original_size")
    var original_size: MTPhotoSizeRemote
)