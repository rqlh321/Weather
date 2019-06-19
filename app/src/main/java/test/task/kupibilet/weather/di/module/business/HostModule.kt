package test.task.kupibilet.weather.di.module.business

import dagger.Module
import dagger.android.ContributesAndroidInjector
import test.task.kupibilet.weather.business.MainActivity

@Module
abstract class HostModule {

    @ContributesAndroidInjector
    protected abstract fun provideMainActivity(): MainActivity

}