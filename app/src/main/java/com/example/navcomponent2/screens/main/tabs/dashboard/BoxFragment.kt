package com.example.navcomponent2.screens.main.tabs.dashboard

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.navcomponent2.R
import com.example.navcomponent2.Repositories
import com.example.navcomponent2.databinding.FragmentBoxBinding
import com.example.navcomponent2.utils.observeEvent
import com.example.navcomponent2.utils.viewModelCreator
import com.example.navcomponent2.views.DashboardItemView

class BoxFragment : Fragment(R.layout.fragment_box) {

    private lateinit var binding: FragmentBoxBinding

    private val viewModel by viewModelCreator { BoxViewModel(getBoxId(), Repositories.boxesRepository) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentBoxBinding.bind(view)

        binding.root.setBackgroundColor(DashboardItemView.getBackgroundColor(getColorValue()))
        binding.boxTextView.text = getString(R.string.this_is_box, getColorName())

        binding.goBackButton.setOnClickListener { onGoBackButtonPressed() }

        listenShouldExitEvent()
    }

    private fun onGoBackButtonPressed() {
        TODO("Go back to the previous screen here")
    }

    private fun listenShouldExitEvent() = viewModel.shouldExitEvent.observeEvent(viewLifecycleOwner) { shouldExit ->
        if (shouldExit) {
            // close the screen if the box has been deactivated
            TODO("Go back to the previous screen here")
        }
    }

    private fun getBoxId(): Int {
        TODO("Extract box id from arguments here")
    }

    private fun getColorValue(): Int {
        TODO("Extract color value from arguments here")
    }

    private fun getColorName(): String {
        TODO("Extract color name from arguments here")
    }

}