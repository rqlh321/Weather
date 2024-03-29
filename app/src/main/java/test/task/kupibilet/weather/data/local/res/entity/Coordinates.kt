package test.task.kupibilet.weather.data.local.res.entity

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Coordinates(
    @SerializedName("lat") val lat: Double,
    @SerializedName("lon") val lon: Double
) : Parcelable {

    constructor(source: Parcel) : this(
        source.readDouble(),
        source.readDouble()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeDouble(lat)
        writeDouble(lon)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Coordinates> = object : Parcelable.Creator<Coordinates> {
            override fun createFromParcel(source: Parcel): Coordinates = Coordinates(source)
            override fun newArray(size: Int): Array<Coordinates?> = arrayOfNulls(size)
        }
    }

}
