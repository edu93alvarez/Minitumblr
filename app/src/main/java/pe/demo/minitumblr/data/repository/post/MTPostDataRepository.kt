package pe.demo.minitumblr.data.repository.post

import io.reactivex.Single
import org.koin.core.KoinComponent
import pe.demo.minitumblr.data.source.post.MTPostDataStoreFactory
import pe.demo.minitumblr.domain.model.MTPost
import pe.demo.minitumblr.domain.repository.MTPostRepository
import pe.demo.minitumblr.util.MTConstants

class MTPostDataRepository(
    val postDataStoreFactory: MTPostDataStoreFactory
) : MTPostRepository, KoinComponent {

    override fun getPosts(blogId: String, postType: Int): Single<List<MTPost>> {
        val postDataStore = postDataStoreFactory.retrieveRemoteDataStore()
        return postDataStore.getPosts(blogId, postType, MTConstants.OAUTH_CUSTOMER_KEY)
    }
}