package pe.demo.minitumblr.remote.model.mapper.post

import pe.demo.minitumblr.domain.model.MTPost
import pe.demo.minitumblr.remote.model.mapper.MTRemoteMapper
import pe.demo.minitumblr.remote.model.posts.MTPostRemoteModel
import pe.demo.minitumblr.remote.model.posts.MTPostResponse

class MTPostResponseMapper : MTRemoteMapper<MTPostResponse, List<MTPost>> {

    override fun mapToRemote(post: List<MTPost>): MTPostResponse {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun mapFromRemote(postResponse: MTPostResponse): List<MTPost> {
        var postList: MutableList<MTPost> = mutableListOf<MTPost>()
        postResponse?.responseData?.posts?.let {
            for (postData in it) {
                postList.add(transformPost(postData))
            }
        }
        return postList
    }

    fun transformPost(postResponse: MTPostRemoteModel): MTPost {
        return MTPost(
            postType = postResponse?.type ?: "",
            postCaption = postResponse?.photoCaption ?: "",
            postBodyText = postResponse?.textBody ?: "",
            postImageUrl = postResponse?.photos?.get(0)?.original_size?.url ?: ""
        )
    }
}