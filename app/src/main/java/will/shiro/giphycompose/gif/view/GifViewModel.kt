package will.shiro.giphycompose.gif.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import will.shiro.giphycompose.gif.api.ApiGif
import will.shiro.giphycompose.gif.api.GifRepository
import will.shiro.giphycompose.utils.extensions.addTo
import will.shiro.giphycompose.utils.scheduler.SchedulerProvider

class GifViewModel constructor(
    private val gifRepository: GifRepository,
    private val schedulerProvider: SchedulerProvider
) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    private val _gifs = MutableLiveData<List<ApiGif>>()

    val gifs: LiveData<List<ApiGif>> = _gifs

    fun getGifs() {
        gifRepository.getGifs()
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
            .subscribe({
                _gifs.postValue(it)
            }) {
            }
            .addTo(compositeDisposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}