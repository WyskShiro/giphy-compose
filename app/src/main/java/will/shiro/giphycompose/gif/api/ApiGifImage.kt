package will.shiro.giphycompose.gif.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiGifImage constructor(
    @Json(name = "url")
    val url: String? = null
)