package will.shiro.giphycompose.gif.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiGif constructor(
    @Json(name = "id")
    val id: String? = null
)