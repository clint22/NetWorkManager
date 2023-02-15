package com.clint.networkmanager.data

import com.google.gson.annotations.SerializedName

data class CustomUI(
    @SerializedName("logo-url") val logo_url: String,
    @SerializedName("heading-text") val heading_text: String? = null,
    @SerializedName("uidata") val ui_data: List<UiData>? = null
)
