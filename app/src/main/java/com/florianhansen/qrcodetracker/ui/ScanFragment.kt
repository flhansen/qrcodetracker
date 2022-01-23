package com.florianhansen.qrcodetracker.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.florianhansen.qrcodetracker.R
import com.florianhansen.qrcodetracker.databinding.FragmentScanBinding
import com.florianhansen.qrcodetracker.mvvm.model.Barcode
import com.florianhansen.qrcodetracker.mvvm.viewmodel.BarcodeViewModel

class ScanFragment : Fragment(R.layout.fragment_scan) {

    private lateinit var nextButton : Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentScanBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_scan, container, false)

        val viewModel = BarcodeViewModel(arguments?.get("barcode") as Barcode)
        binding.barcode = viewModel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        nextButton = view.findViewById(R.id.next_button)
        nextButton.setOnClickListener {
            findNavController().navigateUp()
        }
    }

}