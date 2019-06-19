package test.task.kupibilet.weather.data.local.res.entity

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class City(
    @SerializedName("name") val name: String,
    @SerializedName("country") val country: String,
    @SerializedName("coordinates") val coordinates: Coordinates
) : Parcelable {

    fun id() = coordinates.lat.toString() + coordinates.lon.toString()

    constructor(source: Parcel) : this(
        source.readString(),
        source.readString(),
        source.readParcelable<Coordinates>(Coordinates::class.java.classLoader)
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(name)
        writeString(country)
        writeParcelable(coordinates, 0)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<City> = object : Parcelable.Creator<City> {
            override fun createFromParcel(source: Parcel): City = City(source)
            override fun newArray(size: Int): Array<City?> = arrayOfNulls(size)
        }
    }

}