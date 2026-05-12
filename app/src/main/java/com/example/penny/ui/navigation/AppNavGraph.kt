package com.example.penny.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.penny.ui.screens.PrivacyPolicyScreen
import com.example.penny.ui.screens.SignInScreen
import com.example.penny.ui.screens.SignUpScreen
import com.example.penny.ui.screens.TermsOfServiceScreen

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "signin" // The first screen the user sees
    ) {

        composable("signin") {
            SignInScreen(
                onSignUpClick = { navController.navigate("signup") }
            )
        }

        composable("signup") {
            SignUpScreen(
                onLoginClick = { navController.navigate("signin") },
                onTermsClick = { navController.navigate("terms") },
                onPrivacyClick = { navController.navigate("privacy") }
            )
        }

        composable("terms") {
            TermsOfServiceScreen(
                onBackClick = { navController.popBackStack() }
            )
        }

        composable("privacy") {
            PrivacyPolicyScreen(
                onBackClick = { navController.popBackStack() }
            )
        }



    }
}