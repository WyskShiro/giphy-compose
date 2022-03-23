package will.shiro.giphycompose.utils.scheduler

import org.koin.dsl.module

val schedulerModule = module {

    factory<SchedulerProvider> {
        SchedulerProviderImpl()
    }
}
