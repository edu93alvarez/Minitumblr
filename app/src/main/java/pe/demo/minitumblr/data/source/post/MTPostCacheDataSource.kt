package pe.demo.minitumblr.data.source.post

import io.reactivex.Single
import pe.demo.minitumblr.data.contracts.post.MTPostDataStore
import pe.demo.minitumblr.domain.model.MTPost

class MTPostCacheDataSource : MTPostDataStore {

    override fun getPosts(blogIdentifier: String, postType: Int, apiKey: String): Single<List<MTPost>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}