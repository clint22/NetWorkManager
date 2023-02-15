package com.clint.networkmanager.network

import com.clint.networkmanager.data.CustomUI
import retrofit2.http.GET
import retrofit2.http.Url

interface UiServices {
    @GET
    suspend fun getAssignment(@Url url: String): CustomUI
}