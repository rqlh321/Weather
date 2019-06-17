package test.task.kupibilet.weather.di.module

import dagger.Binds
import dagger.Module
import test.task.kupibilet.weather.usecase.CityUsecase
import test.task.kupibilet.weather.usecase.CityUsecaseImpl
import javax.inject.Singleton

@Module
abstract class UseCaseModule {

    @Binds
    @Singleton
    protected abstract fun provideCityUsecase(impl: CityUsecaseImpl): CityUsecase

}