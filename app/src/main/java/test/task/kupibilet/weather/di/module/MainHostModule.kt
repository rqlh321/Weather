package test.task.kupibilet.weather.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import test.task.kupibilet.weather.MainActivity

@Module
abstract class MainHostModule{

    @ContributesAndroidInjector
    protected abstract fun providesMainActivity(): MainActivity

}