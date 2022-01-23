package com.florianhansen.qrcodetracker.mvvm.viewmodel

import androidx.lifecycle.ViewModel
import com.florianhansen.qrcodetracker.mvvm.model.Barcode

class BarcodeViewModel(private val model: Barcode) : ViewModel() {
    val content: String
        get() = model.content

    val success: Boolean
        get() = !model.isAlreadyRegistererd
}