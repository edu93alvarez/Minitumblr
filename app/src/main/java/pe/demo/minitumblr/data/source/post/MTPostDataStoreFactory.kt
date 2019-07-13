package pe.demo.minitumblr.data.source.post

import org.koin.core.KoinComponent
import pe.demo.minitumblr.data.contracts.post.MTPostDataStore

open class MTPostDataStoreFactory(
    val postCacheDataSource: MTPostCacheDataSource,
    val postRemoteDataSource: MTPostRemoteDataSource
) : KoinComponent {

    open fun retrieveCacheDataStore(): MTPostDataStore {
        return postCacheDataSource
    }

    open fun retrieveRemoteDataStore(): MTPostDataStore {
        return postRemoteDataSource
    }
}