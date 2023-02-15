package com.clint.networkmanager.manager

import com.clint.networkmanager.others.ApiResult
import com.clint.networkmanager.others.CustomNetworkCall
import com.clint.networkmanager.data.CustomUI
import com.clint.networkmanager.others.RetrofitInstance

class CustomUiNetworkManagerImpl : CustomUiNetworkManager {

    override suspend fun fetchCustomUI(url: String): ApiResult<CustomUI> {
        return CustomNetworkCall.safeApiCall {
            RetrofitInstance.getUiServices().getAssignment(url = url)
        }
    }

    override suspend fun fetchLogo(url: String): ApiResult<String> {
        return CustomNetworkCall.safeApiCall {
            RetrofitInstance.getUiServices().getAssignment(url = url).logo_url
        }
    }
}