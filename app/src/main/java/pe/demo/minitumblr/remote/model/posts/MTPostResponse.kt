package pe.demo.minitumblr.remote.model.posts

import com.google.gson.annotations.SerializedName
import pe.demo.minitumblr.remote.base.MTBaseMetaResponse

class MTPostResponse(
    @SerializedName("response")
    val responseData: MTPostResponseData? = null
) : MTBaseMetaResponse()