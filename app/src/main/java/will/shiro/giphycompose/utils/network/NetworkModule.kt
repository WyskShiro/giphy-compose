package will.shiro.giphycompose.utils.network

import org.koin.dsl.module
import will.shiro.giphycompose.utils.network.NetworkService.providesHttpLoggingInterceptor
import will.shiro.giphycompose.utils.network.NetworkService.providesOkHttpClient

val networkModule = module {

    factory {
        providesOkHttpClient(
            httpLoggingInterceptor = get()
        )
    }

    factory { providesHttpLoggingInterceptor() }
}
