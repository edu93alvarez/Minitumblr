package pe.demo.minitumblr.ui

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import pe.com.bvl.votacionmovil.domain.executor.PostExecutionThread

/**
 * MainThread (UI Thread) implementation based on a [Scheduler]
 * which will execute actions on the Android UI thread
 */
class UiThread : PostExecutionThread {

    override val scheduler: Scheduler
        get() = AndroidSchedulers.mainThread()

}