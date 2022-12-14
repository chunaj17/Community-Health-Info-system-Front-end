package com.example.healthinfo.ui.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.healthinfo.core.Resource
import com.example.healthinfo.data.remote.body_request.UserEmailAndPassword
import com.example.healthinfo.domain.repository.AuthRepositoryInterface
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignupViewModel
@Inject
constructor(
    private val authRepositoryInterface: AuthRepositoryInterface
) : ViewModel() {
    private val _signupState = MutableStateFlow(SignupState())
    val signupState = _signupState.asStateFlow()
    private var searchJob: Job? = null
    fun signup(email:String, password:String) {
        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            delay(500L)
            authRepositoryInterface.getSignUpStatus(userData = UserEmailAndPassword(email, password)).onEach { result ->
                when (result) {
                    is Resource.Success -> {
                        _signupState.value = signupState.value.copy(
                            data = result.data,
                            isLoading = false
                        )
                    }
                    is Resource.Loading -> {
                        _signupState.value = signupState.value.copy(
                            data = result.data,
                            isLoading = true
                        )
                    }
                    is Resource.Error -> {
                        _signupState.value = signupState.value.copy(
                            data = result.data,
                            isLoading = false
                        )
                    }
                }
            }.launchIn(this)
        }
    }
}