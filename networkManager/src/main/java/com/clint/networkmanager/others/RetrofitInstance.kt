package com.clint.networkmanager.others

import com.clint.networkmanager.network.UiServices
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://api.npoint.io/"

object RetrofitInstance {
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(
            OkHttpClient()
                .newBuilder()
                .addInterceptor { chain ->
                    chain.proceed(
                        chain
                            .request()
                            .newBuilder()
                            .build()
                    )
                }
                .build()
        )
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getUiServices(): UiServices {
        return retrofit.create(UiServices::class.java)
    }
}