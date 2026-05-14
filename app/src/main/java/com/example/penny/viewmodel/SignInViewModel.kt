package com.example.penny.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.penny.data.AuthResult
import com.example.penny.data.repository.AuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SignInViewModel: ViewModel(){
    private val repository = AuthRepository()

    private val _email = MutableStateFlow("")
    val email = _email.asStateFlow()

    private val _password = MutableStateFlow("")
    val password = _password.asStateFlow()

    private val _authState = MutableStateFlow<AuthResult?>(null)
    val authState = _authState.asStateFlow()

    fun onEmailChange(value: String) { _email.value = value }
    fun onPasswordChange(value: String) { _password.value = value }

    fun signIn(){
        viewModelScope.launch {
            _authState.value = AuthResult.Loading

            val result = repository.signIn(_email.value, _password.value)

            _authState.value = result
        }
    }

    fun forgotPassword(){
        viewModelScope.launch {
            _authState.value = AuthResult.Loading

            val result = repository.forgotPassword(_email.value)
            _authState.value = result
        }
    }
}