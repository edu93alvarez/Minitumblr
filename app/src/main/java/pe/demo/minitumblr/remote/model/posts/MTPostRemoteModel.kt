package pe.demo.minitumblr.remote.model.posts

import com.google.gson.annotations.SerializedName

class MTPostRemoteModel(
    @SerializedName("type")
    val type: String? = null,
    @SerializedName("caption")
    val photoCaption: String? = null,
    @SerializedName("photos")
    val photos: List<MTPhotoPostRemote>,
    @SerializedName("body")
    val textBody: String? = null
) {
}