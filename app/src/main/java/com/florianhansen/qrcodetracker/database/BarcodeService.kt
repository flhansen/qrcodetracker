package com.florianhansen.qrcodetracker.database

import com.florianhansen.qrcodetracker.model.Barcode
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface BarcodeService {

    @POST("barcodes/new")
    fun registerBarcode(@Body id: Int) : Call<Barcode>

}