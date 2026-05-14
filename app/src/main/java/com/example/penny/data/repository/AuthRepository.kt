package com.example.penny.data.repository

import com.example.penny.data.AuthResult
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await

class AuthRepository{
    private val auth = FirebaseAuth.getInstance()

    suspend fun signUp(email: String, password: String): AuthResult{
        try {
            auth.createUserWithEmailAndPassword(email,password).await()
            return AuthResult.Success

        }catch(e: Exception){
            return AuthResult.Error(e.message?: "Registration failed")
        }
    }

    suspend fun signIn(email: String, password: String): AuthResult{
        try {
            auth.signInWithEmailAndPassword(email, password).await()
            return AuthResult.Success
        }catch (e: Exception){
            return AuthResult.Error(e.message?: "Login failed")
        }

    }

    suspend fun forgotPassword(email: String): AuthResult{
        try {
            auth.sendPasswordResetEmail(email).await()
            return AuthResult.Success
        }catch (e: Exception){
            return AuthResult.Error(e.message?: "Reset password link failed!")
        }
    }
}