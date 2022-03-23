package will.shiro.giphycompose.gif.view

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import will.shiro.giphycompose.gif.api.GifRepository
import will.shiro.giphycompose.utils.extensions.addTo
import will.shiro.giphycompose.utils.scheduler.SchedulerProvider

class GifViewModel constructor(
    private val gifRepository: GifRepository,
    private val schedulerProvider: SchedulerProvider
) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    fun getGifs() {
        gifRepository.getGifs()
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
            .subscribe({
            }) {
            }
            .addTo(compositeDisposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}