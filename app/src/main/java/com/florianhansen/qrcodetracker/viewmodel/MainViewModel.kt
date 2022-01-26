package com.florianhansen.qrcodetracker.viewmodel

import androidx.lifecycle.ViewModel
import com.florianhansen.qrcodetracker.model.Barcode
import com.florianhansen.qrcodetracker.model.Settings

class MainViewModel : ViewModel() {

    var barcodeViewModel: BarcodeViewModel = BarcodeViewModel(Barcode())
    var settingsViewModel: SettingsViewModel = SettingsViewModel(Settings())

}