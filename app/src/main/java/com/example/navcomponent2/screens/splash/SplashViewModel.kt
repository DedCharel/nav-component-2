package com.example.navcomponent2.screens.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.navcomponent2.model.accounts.AccountsRepository
import com.example.navcomponent2.utils.MutableLiveEvent
import com.example.navcomponent2.utils.publishEvent
import com.example.navcomponent2.utils.share
import kotlinx.coroutines.launch

/**
 * SplashViewModel checks whether user is signed-in or not.
 */
class SplashViewModel(
    private val accountsRepository: AccountsRepository
) : ViewModel() {

    private val _launchMainScreenEvent = MutableLiveEvent<Boolean>()
    val launchMainScreenEvent = _launchMainScreenEvent.share()

    init {
        viewModelScope.launch {
            _launchMainScreenEvent.publishEvent(accountsRepository.isSignedIn())
        }
    }
}