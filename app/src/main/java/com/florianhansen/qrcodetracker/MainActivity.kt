package com.florianhansen.qrcodetracker

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    companion object {
        const val REQUEST_CODE_CAMERA_PERMISSION = 10
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Request permissions
        requestActivityPermissions()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            REQUEST_CODE_CAMERA_PERMISSION -> {
                if (grantResults.isNotEmpty() && grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(applicationContext, "Permission denied", Toast.LENGTH_SHORT).show()
                }
            }
            else -> {
                super.onRequestPermissionsResult(requestCode, permissions, grantResults)
            }
        }
    }

    private fun requestCameraPermission() {
        requestPermissions(arrayOf(Manifest.permission.CAMERA), REQUEST_CODE_CAMERA_PERMISSION)
    }

    private fun requestActivityPermissions() {
        when {
            shouldShowRequestPermissionRationale(Manifest.permission.CAMERA) -> {
                requestCameraPermission()
            }
            else -> {
                requestCameraPermission()
            }
        }
    }

}