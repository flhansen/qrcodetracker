package com.florianhansen.qrcodetracker.ui

import android.os.Bundle
import android.util.Size
import android.view.View
import androidx.camera.camera2.Camera2Config
import androidx.camera.core.*
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import com.florianhansen.qrcodetracker.R
import com.florianhansen.qrcodetracker.helper.ImageHelper.Companion.toBitmap

class CameraFragment : Fragment(R.layout.fragment_camera), CameraXConfig.Provider, ImageAnalysis.Analyzer {
    private var isScanning: Boolean = false
    private lateinit var cameraPreviewView: PreviewView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cameraPreviewView = view.findViewById(R.id.cameraPreviewView)
        startCameraPreview()
    }

    private fun startCameraPreview() {
        val cameraProviderFuture = ProcessCameraProvider.getInstance(context!!)

        cameraProviderFuture.addListener(Runnable {
            val cameraProvider = cameraProviderFuture.get()
            bindPreview(cameraProvider)
        }, ContextCompat.getMainExecutor(context))
    }

    private fun bindPreview(cameraProvider: ProcessCameraProvider) {
        val preview = Preview.Builder()
            .build()

        val cameraSelector = CameraSelector.Builder()
            .requireLensFacing(CameraSelector.LENS_FACING_BACK)
            .build()

        val imageAnalysis = ImageAnalysis.Builder()
            .setTargetResolution(Size(1280, 720))
            .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
            .build()

        imageAnalysis.setAnalyzer(ContextCompat.getMainExecutor(context), this)

        preview.setSurfaceProvider(cameraPreviewView.surfaceProvider)
        cameraProvider.bindToLifecycle(this as LifecycleOwner, cameraSelector, imageAnalysis, preview)
    }

    override fun getCameraXConfig(): CameraXConfig {
        return Camera2Config.defaultConfig()
    }

    override fun analyze(image: ImageProxy) {
        val bitmap = image.toBitmap()
        image.close()

        if (!isScanning) {
            isScanning = true

            Thread {
                // TODO: Implement QR code scanning here.
                isScanning = false
            }.start()
        }
    }

}