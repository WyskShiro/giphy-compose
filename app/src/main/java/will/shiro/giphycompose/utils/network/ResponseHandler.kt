package will.shiro.giphycompose.utils.network

import android.util.Log
import io.reactivex.Single
import retrofit2.Response

private const val TAG = "ResponseHandler"

object ResponseHandler {

    fun <T> Single<Response<T>>.handleResponse(): Single<T> {
        return map {
            if (it.isSuccessful) it.body()!!
            else {
                Log.d(TAG, it.errorBody().toString())
                throw RuntimeException(it.errorBody().toString())
            }
        }
    }
}
