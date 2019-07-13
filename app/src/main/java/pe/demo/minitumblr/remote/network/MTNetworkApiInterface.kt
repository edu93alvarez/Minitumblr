package pe.demo.minitumblr.remote.network

import io.reactivex.Single
import pe.demo.minitumblr.remote.model.posts.MTPostResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MTNetworkApiInterface {
    @GET(MTNetworkApiConstants.URI_GET_POSTS)
    fun getPosts(
        @Path("blog-identifier") blogIdentifier: String, @Path("post-type") postType: String, @Query(
            "api_key"
        ) apiKey: String, @Query("filter") filter: String
    ): Single<MTPostResponse>
}