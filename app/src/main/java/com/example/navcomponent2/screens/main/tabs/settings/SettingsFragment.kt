package com.example.navcomponent2.screens.main.tabs.settings


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.navcomponent2.R
import com.example.navcomponent2.Repositories
import com.example.navcomponent2.databinding.FragmentSettingsBinding
import com.example.navcomponent2.utils.viewModelCreator

class SettingsFragment : Fragment(R.layout.fragment_settings) {

    private lateinit var binding: FragmentSettingsBinding

    private val viewModel by viewModelCreator { SettingsViewModel(Repositories.boxesRepository) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSettingsBinding.bind(view)

        val adapter = setupList()
        viewModel.boxSettings.observe(viewLifecycleOwner) { adapter.renderSettings(it) }
    }

    private fun setupList(): SettingsAdapter {
        binding.settingsList.layoutManager = LinearLayoutManager(requireContext())
        val adapter = SettingsAdapter(viewModel)
        binding.settingsList.adapter = adapter
        return adapter
    }

}