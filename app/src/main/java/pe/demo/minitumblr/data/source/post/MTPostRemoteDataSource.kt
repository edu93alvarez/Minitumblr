package pe.demo.minitumblr.data.source.post

import io.reactivex.Single
import org.koin.core.KoinComponent
import pe.demo.minitumblr.data.contracts.post.MTPostDataStore
import pe.demo.minitumblr.data.contracts.post.MTPostRemote
import pe.demo.minitumblr.domain.model.MTPost

class MTPostRemoteDataSource(val postRemote: MTPostRemote) : MTPostDataStore, KoinComponent {

    override fun getPosts(blogIdentifier: String, postType: Int, apiKey: String): Single<List<MTPost>> {
        return postRemote.getPosts(blogIdentifier, postType, apiKey)
    }
}