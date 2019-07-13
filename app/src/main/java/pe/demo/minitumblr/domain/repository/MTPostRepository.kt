package pe.demo.minitumblr.domain.repository

import io.reactivex.Single
import pe.demo.minitumblr.domain.model.MTPost

interface MTPostRepository {
    fun getPosts(blogId: String, postType: Int): Single<List<MTPost>>
}