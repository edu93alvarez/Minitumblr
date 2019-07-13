package pe.demo.minitumblr.data.contracts.post

import io.reactivex.Single
import pe.demo.minitumblr.domain.model.MTPost

interface MTPostDataStore {
    fun getPosts(blogIdentifier: String, postType: Int, apiKey: String): Single<List<MTPost>>
}