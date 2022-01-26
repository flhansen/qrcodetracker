package com.florianhansen.qrcodetracker.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.florianhansen.qrcodetracker.R
import com.florianhansen.qrcodetracker.databinding.FragmentSettingsBinding
import com.florianhansen.qrcodetracker.viewmodel.MainViewModel

class SettingsFragment : Fragment(R.layout.fragment_settings) {
    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentSettingsBinding.inflate(inflater, container, false)

        binding.viewModel = mainViewModel.settingsViewModel
        binding.lifecycleOwner = this

        return binding.root
    }
}