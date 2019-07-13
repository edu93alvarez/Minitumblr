package pe.demo.minitumblr.remote.base

import com.google.gson.annotations.SerializedName

class MTBaseMeta(
    @SerializedName("status")
    var status: Int? = null,
    @SerializedName("msg")
    var msg: String? = null
)