package com.clint.networkmanager.data

import com.google.gson.annotations.SerializedName

data class UiData(
    @SerializedName("uitype") val ui_type: String? = null,
    @SerializedName("value") val value: String? = null,
    @SerializedName("key") val key: String? = null
)
