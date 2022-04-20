package will.shiro.giphycompose.gif.view

import android.os.Build.VERSION.SDK_INT
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import org.koin.androidx.viewmodel.ext.android.getViewModel
import will.shiro.giphycompose.gif.api.ApiGif
import will.shiro.giphycompose.utils.uicompose.theme.GiphyComposeTheme

class MainActivity : ComponentActivity() {

    private val viewModel by lazy {
        getViewModel<GifViewModel>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GiphyComposeTheme {
                MainActivityComposable()
            }
        }
    }

    private fun setUpObservers() {
        viewModel.getGifs()
    }

    @Composable
    fun MainActivityComposable() {
        val gifs = remember { mutableStateOf<List<ApiGif>>(listOf()) }
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
            GifsList(gifs = gifs.value)
        }
        setUpObservers()
        viewModel.gifs.observe(this) {
            gifs.value = it
        }
    }

    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    fun GifsList(gifs: List<ApiGif>) {
        LazyVerticalGrid(cells = GridCells.Fixed(2)) {
            items(gifs) { item ->
                GifView(url = item.images?.get("original")!!.url!!)
            }
        }
    }

    @Composable
    fun GifView(url: String) {
        val imageLoader = ImageLoader.Builder(this)
            .components {
                if (SDK_INT >= 28) {
                    add(ImageDecoderDecoder.Factory())
                } else {
                    add(GifDecoder.Factory())
                }
            }
            .build()

        AsyncImage(
            model = url,
            contentDescription = null,
            imageLoader = imageLoader,
            modifier = Modifier.fillMaxWidth()
        )
    }
}
