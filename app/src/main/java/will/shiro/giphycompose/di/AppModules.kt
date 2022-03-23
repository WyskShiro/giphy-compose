package will.shiro.giphycompose.di

import will.shiro.giphycompose.gif.di.GifModule
import will.shiro.giphycompose.utils.network.networkModule
import will.shiro.giphycompose.utils.scheduler.schedulerModule

object AppModules {
    fun modules() = arrayOf(
        networkModule,
        schedulerModule,
        GifModule.module()
    )
}