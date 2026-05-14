package com.example.penny.data

sealed class AuthResult{
    object Success : AuthResult()
    object Loading : AuthResult()
    data class Error(val message : String) : AuthResult()
}