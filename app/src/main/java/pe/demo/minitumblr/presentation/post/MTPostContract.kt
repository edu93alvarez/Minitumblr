package pe.demo.minitumblr.presentation.post

import pe.demo.minitumblr.domain.model.MTPost
import pe.mambo.ahorakotlin.presentation.base.MTBasePresenter
import pe.mambo.ahorakotlin.presentation.base.MTBaseView

interface MTPostContract {
    interface View : MTBaseView<Presenter> {
        fun onSuccessGetPosts(posts: List<MTPost>)
        fun onFailureGetPosts(message: String)
    }

    interface Presenter : MTBasePresenter<View> {
        fun getPosts(blogId: String, postsType: Int)
    }
}