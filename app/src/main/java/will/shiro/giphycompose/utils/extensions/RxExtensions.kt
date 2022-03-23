package will.shiro.giphycompose.utils.extensions

import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

fun Disposable.addTo(disposables: CompositeDisposable) {
    disposables.add(this)
}

fun <T> T.toSingle(): Single<T> {
    return Single.just(this)
}

fun <T> Throwable.toSingleError(): Single<T> {
    return Single.error(this)
}