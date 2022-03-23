package will.shiro.giphycompose.gif.api

import io.reactivex.Single
import will.shiro.giphycompose.utils.network.ResponseHandler.handleResponse

class GifRepository constructor(
    private val apiService: ApiService
) {

    fun getGifs(): Single<List<ApiGif>> {
        return apiService.getGifs().handleResponse()
    }
}