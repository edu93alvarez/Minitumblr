package pe.demo.minitumblr.remote.model.posts

import com.google.gson.annotations.SerializedName

class MTPhotoSizeRemote(
    @SerializedName("url")
    var url: String? = null,
    @SerializedName("width")
    var width: Int? = null,
    @SerializedName("height")
    var height: Int? = null
)