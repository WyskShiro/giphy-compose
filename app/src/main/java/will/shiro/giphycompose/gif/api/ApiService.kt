package will.shiro.giphycompose.gif.api

import com.serjltt.moshi.adapters.Wrapped
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import will.shiro.giphycompose.BuildConfig

interface ApiService {

    @GET("gifs/trending")
    @Wrapped(path = ["data"])
    fun getGifs(
        @Query("api_key", encoded = true) apiKey: String = BuildConfig.API_KEY,
        @Query("limit", encoded = true) limit: Int = 25,
        @Query("rating", encoded = true) rating: String = "g"
    ): Single<Response<List<ApiGif>>>
}