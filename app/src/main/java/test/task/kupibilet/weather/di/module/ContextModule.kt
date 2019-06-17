package test.task.kupibilet.weather.di.module

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class ContextModule {

    @Binds
    @Singleton
    protected abstract fun provideContext(application: Application): Context

}
