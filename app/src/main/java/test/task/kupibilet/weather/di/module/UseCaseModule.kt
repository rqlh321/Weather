package test.task.kupibilet.weather.di.module

import dagger.Binds
import dagger.Module
import test.task.kupibilet.weather.usecase.city.CityUseCase
import test.task.kupibilet.weather.usecase.city.CityUseCaseImpl
import javax.inject.Singleton

@Module
abstract class UseCaseModule {

    @Binds
    @Singleton
    protected abstract fun provideCityUsecase(impl: CityUseCaseImpl): CityUseCase

}