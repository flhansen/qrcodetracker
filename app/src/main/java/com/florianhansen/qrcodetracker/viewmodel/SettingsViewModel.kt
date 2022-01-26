package com.florianhansen.qrcodetracker.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.florianhansen.qrcodetracker.model.Settings
import kotlinx.coroutines.launch
import java.lang.Integer.parseInt
import java.net.InetAddress

class SettingsViewModel(private val model: Settings) : ViewModel() {
    var hostname: String
        get() = model.hostname
        set(value) { model.hostname = value }

    var port: String
        get() = model.port.toString()
        set(value) { model.port = parseInt(value) }

    var isReachable: MutableLiveData<Boolean> = MutableLiveData(false)

    fun testConnection() {
        viewModelScope.launch {
            Log.i("IP", "Testing $hostname")
            val address = InetAddress.getByName(hostname)
            isReachable.value = address.isReachable(3000)
            Log.i("IP", "Test result: ${isReachable.value}")
        }
    }
}