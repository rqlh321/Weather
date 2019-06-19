package test.task.kupibilet.weather.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import test.task.kupibilet.weather.di.module.ContextModule
import test.task.kupibilet.weather.di.module.DataAccessModule
import test.task.kupibilet.weather.di.module.business.CitiesModule
import test.task.kupibilet.weather.di.module.UseCaseModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ContextModule::class,
        UseCaseModule::class,
        DataAccessModule::class,

        CitiesModule::class
    ]
)
interface AppComponent : AndroidInjector<DaggerApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent

    }

}
