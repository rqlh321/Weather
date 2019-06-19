package test.task.kupibilet.weather.di.module.business

import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import test.task.kupibilet.weather.business.weather.WeatherContract
import test.task.kupibilet.weather.business.weather.WeatherFragment
import test.task.kupibilet.weather.business.weather.WeatherPresenter
import test.task.kupibilet.weather.usecase.weather.WeatherUseCase
import test.task.kupibilet.weather.usecase.weather.WeatherUseCaseImpl
import javax.inject.Singleton

@Module
abstract class WeatherModule {

    @Binds
    @Singleton
    protected abstract fun provideWeatherUsecase(impl: WeatherUseCaseImpl): WeatherUseCase

    @ContributesAndroidInjector
    protected abstract fun provideWeatherFragment(): WeatherFragment

    @Binds
    protected abstract fun provideView(impl: WeatherFragment): WeatherContract.View

    @Binds
    protected abstract fun providePresenter(impl: WeatherPresenter): WeatherContract.Presenter

}