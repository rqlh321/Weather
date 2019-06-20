package test.task.kupibilet.weather.data.local.database.entity

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import test.task.kupibilet.weather.R
import test.task.kupibilet.weather.common.ListItem
import test.task.kupibilet.weather.data.network.openweathermap.pojo.OpenWeatherResponse
import java.text.SimpleDateFormat
import java.util.*

@Entity(tableName = "WEATHER")
data class Weather(
    var cityId: String = "",
    var title: String = "",
    var description: String = "",
    var timestamp: Long = 0,
    var timestampPreview: String = ""
) : ListItem, Parcelable {
    override fun layout() = R.layout.list_item_weather

    @PrimaryKey
    var primaryKey: String = UUID.randomUUID().toString()

    constructor(cityId: String, data: OpenWeatherResponse.WeatherCondition) : this(
        cityId,
        data.main.toString(),
        data.toString(),
        System.currentTimeMillis(),
        CREATE_FORMAT.format(System.currentTimeMillis())
    )

    constructor(source: Parcel) : this(
        source.readString(),
        source.readString(),
        source.readString(),
        source.readLong(),
        source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(cityId)
        writeString(title)
        writeString(description)
        writeLong(timestamp)
        writeString(timestampPreview)
    }

    companion object {
        private var CREATE_FORMAT = SimpleDateFormat("HH:mm")

        @JvmField
        val CREATOR: Parcelable.Creator<Weather> = object : Parcelable.Creator<Weather> {
            override fun createFromParcel(source: Parcel): Weather = Weather(source)
            override fun newArray(size: Int): Array<Weather?> = arrayOfNulls(size)
        }
    }
}