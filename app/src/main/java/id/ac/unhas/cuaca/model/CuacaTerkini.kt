package id.ac.unhas.cuaca.model

import com.google.gson.annotations.SerializedName

data class CuacaTerkini(
        val location: Location,
        @SerializedName("current")
    val currentWeatherEntry: CurrentWeatherEntry,
    val request: Request
)
