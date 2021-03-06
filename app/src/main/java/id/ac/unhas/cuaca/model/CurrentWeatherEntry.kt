package id.ac.unhas.cuaca.model

import com.google.gson.annotations.SerializedName

data class CurrentWeatherEntry(
        @SerializedName("cloud_cover")
    val cloudcover: Int,
        @SerializedName("feels_like")
    val feelslike: Int,
        @SerializedName("humadity")
    val humidity: Int,
        @SerializedName("is_day")
    val is_day: String,
        @SerializedName("observation_time")
    val observation_time: String,
        @SerializedName("precip")
    val precip: Double,
        @SerializedName("pressure")
    val pressure: Int,
        @SerializedName("temperature")
    val temperature: Int,
        @SerializedName("uv_index")
    val uv_index: Int,
        @SerializedName("visibility")
    val visibility: Int,
        @SerializedName("weather_code")
    val weather_code: Int,
        @SerializedName("weather_description")
    val weather_descriptions: List<String>,
        @SerializedName("weather_icons")
    val weather_icons: List<String>,
        @SerializedName("wind_degree")
    val wind_degree: Int,
        @SerializedName("wind_dir")
    val wind_dir: String,
        @SerializedName("wind_speed")
    val wind_speed: Int
)