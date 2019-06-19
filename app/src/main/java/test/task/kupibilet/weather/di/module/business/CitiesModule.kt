package test.task.kupibilet.weather.di.module.business

import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import test.task.kupibilet.weather.business.MainActivity
import test.task.kupibilet.weather.business.cities.CitiesContract
import test.task.kupibilet.weather.business.cities.CitiesFragment
import test.task.kupibilet.weather.business.cities.CitiesPresenter
import test.task.kupibilet.weather.usecase.city.CityUseCase
import test.task.kupibilet.weather.usecase.city.CityUseCaseImpl
import javax.inject.Singleton

@Module
abstract class CitiesModule {

    @Binds
    @Singleton
    protected abstract fun provideCityUsecase(impl: CityUseCaseImpl): CityUseCase

    @ContributesAndroidInjector
    protected abstract fun provideCitiesFragment(): CitiesFragment

    @Binds
    protected abstract fun provideView(impl: CitiesFragment): CitiesContract.View

    @Binds
    protected abstract fun providePresenter(impl: CitiesPresenter): CitiesContract.Presenter

}