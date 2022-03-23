package will.shiro.giphycompose.gif.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import will.shiro.giphycompose.BuildConfig.API_URL
import will.shiro.giphycompose.gif.api.ApiService
import will.shiro.giphycompose.gif.api.GifRepository
import will.shiro.giphycompose.gif.view.GifViewModel
import will.shiro.giphycompose.utils.network.NetworkService.providesRetrofit

object GifModule {

    fun module() = module {
        factory<ApiService> {
            providesRetrofit(
                API_URL,
                get()
            )
        }
        factory { GifRepository(get()) }

        viewModel { GifViewModel(get(), get()) }
    }
}