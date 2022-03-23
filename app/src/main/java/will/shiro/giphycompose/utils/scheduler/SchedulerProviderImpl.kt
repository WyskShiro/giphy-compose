package will.shiro.giphycompose.utils.scheduler

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import will.shiro.giphycompose.utils.scheduler.SchedulerProvider

class SchedulerProviderImpl : SchedulerProvider {
    override fun computation() = Schedulers.computation()
    override fun ui() = AndroidSchedulers.mainThread()
    override fun io() = Schedulers.io()
}
