package pe.demo.minitumblr.remote.base

import com.google.gson.annotations.SerializedName

open class MTBaseMetaResponse(
    @SerializedName("meta")
    var meta: MTBaseMeta? = null
)
