package pe.demo.minitumblr.di

import org.koin.core.qualifier.named
import org.koin.dsl.module
import pe.com.bvl.votacionmovil.data.executor.JobExecutor
import pe.com.bvl.votacionmovil.domain.executor.PostExecutionThread
import pe.com.bvl.votacionmovil.domain.executor.ThreadExecutor
import pe.demo.minitumblr.data.contracts.post.MTPostRemote
import pe.demo.minitumblr.data.repository.post.MTPostDataRepository
import pe.demo.minitumblr.data.source.post.MTPostCacheDataSource
import pe.demo.minitumblr.data.source.post.MTPostDataStoreFactory
import pe.demo.minitumblr.data.source.post.MTPostRemoteDataSource
import pe.demo.minitumblr.domain.interactor.MTPostUserCase
import pe.demo.minitumblr.domain.repository.MTPostRepository
import pe.demo.minitumblr.presentation.post.MTPostContract
import pe.demo.minitumblr.presentation.post.MTPostPresenter
import pe.demo.minitumblr.remote.impl.post.MTPostRemoteImpl
import pe.demo.minitumblr.remote.model.mapper.post.MTPostResponseMapper
import pe.demo.minitumblr.ui.UiThread


val postModule = module {
    factory<MTPostContract.Presenter> { MTPostPresenter() }
}

val postRepositoryModule = module {
    single<ThreadExecutor>(named("threadExecutor")) { JobExecutor() }
    single<PostExecutionThread>(named("postExecutionThread")) { UiThread() }

    single { MTPostResponseMapper() }
    single<MTPostRemote> {
        MTPostRemoteImpl(get(), get())
    }
    single { MTPostCacheDataSource() }
    single { MTPostRemoteDataSource(get()) }
    single { MTPostDataStoreFactory(get(), get()) }
    single<MTPostRepository>(named("postRepository")) { MTPostDataRepository(get()) }

    factory {
        MTPostUserCase(
            get(named("postRepository")),
            get(named("threadExecutor")),
            get(named("postExecutionThread"))
        )
    }
}

