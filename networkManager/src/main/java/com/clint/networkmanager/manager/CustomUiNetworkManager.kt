package com.clint.networkmanager.manager

import com.clint.networkmanager.others.ApiResult
import com.clint.networkmanager.data.CustomUI

interface CustomUiNetworkManager {
    suspend fun fetchCustomUI(url: String): ApiResult<CustomUI>?
    suspend fun fetchLogo(url: String): ApiResult<String>?
}