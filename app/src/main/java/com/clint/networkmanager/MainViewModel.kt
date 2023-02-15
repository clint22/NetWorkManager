package com.clint.networkmanager

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.clint.networkmanager.data.CustomUI
import com.clint.networkmanager.manager.CustomUiNetworkManager
import com.clint.networkmanager.manager.CustomUiNetworkManagerImpl
import com.clint.networkmanager.others.ApiResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _customUi = MutableStateFlow<CustomUI?>(null)
    var customUi: StateFlow<CustomUI?> = _customUi

    private val _customLogo = MutableStateFlow<String?>(null)
    var customLogo: StateFlow<String?> = _customLogo

    private val _errorHandling = MutableStateFlow<String?>(null)
    var errorHandling: StateFlow<String?> = _errorHandling

    private val customUiNetworkManager: CustomUiNetworkManager by lazy {
        CustomUiNetworkManagerImpl()
    }

    fun fetchCustomUi(url: String) {
        viewModelScope.launch {
            when(val response = customUiNetworkManager.fetchCustomUI(url)) {
                is ApiResult.Success ->  _customUi.value = response.data
                is ApiResult.Error ->  _errorHandling.value = response.exception?.message
                else -> _errorHandling.value = "Sorry, some error occurred"
            }
        }
    }

    fun fetchCustomLogo(url: String) {
        viewModelScope.launch {
            when(val response = customUiNetworkManager.fetchLogo(url)) {
                is ApiResult.Success ->  _customLogo.value = response.data
                is ApiResult.Error ->  _errorHandling.value = response.exception?.message
                else -> _errorHandling.value = "Sorry, some error occurred"
            }
        }
    }
}
