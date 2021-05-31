package id.ac.unhas.cuaca.model.network

import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import id.ac.unhas.cuaca.model.CuacaTerkini
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory

const val API_KEY = "7e2f8a0bafb5659d2a8930e09760ffff"

//http://api.weatherstack.com/current?access_key=7e2f8a0bafb5659d2a8930e09760ffff&query=Indonesia

interface CurrentApiService {
    @GET("current")
    fun getCurrentWeather(
            @Query("q") location: String,
            @Query("lang") languageCode: String = "en"
    ): Deferred<CuacaTerkini>

    companion object {
        operator fun invoke(): CurrentApiService {
            val requestInterceptor = Interceptor { chain ->

                val url = chain.request()
                        .url()
                        .newBuilder()
                        .addQueryParameter("key", API_KEY)
                        .build()
                val request = chain.request()
                        .newBuilder()
                        .url(url)
                        .build()

                return@Interceptor chain.proceed(request)
            }

            val okHttpClient = OkHttpClient.Builder()
                    .addInterceptor(requestInterceptor)
                    .build()

            return Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl("http://api.weatherstack.com/")
                    .addCallAdapterFactory(CoroutineCallAdapterFactory())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(CurrentApiService::class.java)
        }
    }
}