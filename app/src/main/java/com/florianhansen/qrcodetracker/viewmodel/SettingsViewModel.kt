package com.florianhansen.qrcodetracker.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.florianhansen.qrcodetracker.model.Settings
import kotlinx.coroutines.launch
import java.net.InetAddress

class SettingsViewModel(private val model: Settings) : ViewModel() {
    var hostname: String
        get() = model.hostname
        set(value) { model.hostname = value }

    var port: String
        get() = model.port.toString()
        set(value) { model.port = value.toIntOrNull() ?: 0 }

    var isReachable: MutableLiveData<Boolean> = MutableLiveData(false)

    fun testConnection() {
        viewModelScope.launch {
            val address = InetAddress.getByName(hostname)
            isReachable.value = address.isReachable(3000)
        }
    }
}