package pe.demo.minitumblr.remote.impl.post

import io.reactivex.Single
import pe.demo.minitumblr.data.contracts.post.MTPostRemote
import pe.demo.minitumblr.domain.model.MTPost
import pe.demo.minitumblr.remote.model.mapper.post.MTPostResponseMapper
import pe.demo.minitumblr.remote.network.MTNetworkApiInterface
import pe.demo.minitumblr.util.MTConstants

class MTPostRemoteImpl(
    private val networkApiInterface: MTNetworkApiInterface,
    private val postMapper: MTPostResponseMapper
) : MTPostRemote {

    override fun getPosts(blogIdentifier: String, postType: Int, apiKey: String): Single<List<MTPost>> {
        val strPostType =
            if (postType == MTConstants.POST_TEXT_TYPE) MTConstants.STR_TEXT_TYPE else MTConstants.STR_PHOTO_TYPE
        return networkApiInterface.getPosts(blogIdentifier, strPostType, apiKey, MTConstants.POST_FILTER)
            .map { it ->
                postMapper.mapFromRemote(it)
            }
    }
}