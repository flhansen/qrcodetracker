package com.florianhansen.qrcodetracker.viewmodel

import androidx.lifecycle.ViewModel
import com.florianhansen.qrcodetracker.model.Barcode

class BarcodeViewModel(private val model: Barcode) : ViewModel() {
    val content: String
        get() = model.id.toString()

    val isRegistered: Boolean
        get() = model.scanDate != null
}