package com.ariefaryudisyidik.store.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.ariefaryudisyidik.store.domain.usecase.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    fun login(username: String, password: String) =
        loginUseCase.invoke(username, password).asLiveData()
}