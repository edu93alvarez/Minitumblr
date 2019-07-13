package pe.demo.minitumblr.domain.interactor

import io.reactivex.Single
import org.koin.core.KoinComponent
import pe.com.bvl.votacionmovil.domain.executor.PostExecutionThread
import pe.com.bvl.votacionmovil.domain.executor.ThreadExecutor
import pe.com.bvl.votacionmovil.domain.interactor.SingleUseCase
import pe.demo.minitumblr.domain.model.MTPost
import pe.demo.minitumblr.domain.repository.MTPostRepository

class MTPostUserCase(
    val postRepository: MTPostRepository,
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread
) : SingleUseCase<List<MTPost>, MTPostUserCase.Params>(threadExecutor, postExecutionThread), KoinComponent {

    override fun buildUseCaseObservable(params: MTPostUserCase.Params?): Single<List<MTPost>> {
        return postRepository.getPosts(params!!.blogId, params!!.postType)
    }

    class Params constructor(var blogId: String, var postType: Int) {
    }

}