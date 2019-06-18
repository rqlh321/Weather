package test.task.kupibilet.weather.di.module

import androidx.room.Room
import android.content.Context
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import test.task.kupibilet.weather.R
import test.task.kupibilet.weather.data.local.database.SQLiteDatabase
import test.task.kupibilet.weather.data.network.openweathermap.OpenWeather
import test.task.kupibilet.weather.data.network.openweathermap.OpenWeatherMapApi
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class DataAccessModule {

    @Provides
    @Singleton
    protected fun provideRoomModule(context: Context): SQLiteDatabase =
        Room.databaseBuilder(context, SQLiteDatabase::class.java, context.getString(R.string.db_name))
            .build()


    @Provides
    @Singleton
    protected fun provideApiService(context: Context): OpenWeather {
        return OpenWeather(
            context.getString(R.string.open_weather_map_ip),
            context.getString(R.string.open_weather_map_api_key_key),
            context.getString(R.string.open_weather_map_api_key_value)
        )
    }

}