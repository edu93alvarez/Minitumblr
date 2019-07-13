package pe.demo.minitumblr.presentation.post

import io.reactivex.observers.DisposableSingleObserver
import org.koin.core.KoinComponent
import org.koin.core.inject
import pe.com.bvl.votacionmovil.domain.interactor.SingleUseCase
import pe.demo.minitumblr.domain.interactor.MTPostUserCase
import pe.demo.minitumblr.domain.model.MTPost

class MTPostPresenter : MTPostContract.Presenter, KoinComponent {

    override lateinit var view: MTPostContract.View
    val postUseCase: SingleUseCase<List<MTPost>, MTPostUserCase.Params> by inject<MTPostUserCase>()

    override fun getPosts(blogId: String, postsType: Int) {
        view.showProgressLoading()
        postUseCase.execute(PostSubscriber(), MTPostUserCase.Params(blogId, postsType))
    }

    inner class PostSubscriber : DisposableSingleObserver<List<MTPost>>() {

        override fun onError(e: Throwable) {
            view.hideProgressLoading()
            view.onFailureGetPosts(e.message.toString())
        }

        override fun onSuccess(t: List<MTPost>) {
            view.hideProgressLoading()
            view.onSuccessGetPosts(t)
        }

    }

}