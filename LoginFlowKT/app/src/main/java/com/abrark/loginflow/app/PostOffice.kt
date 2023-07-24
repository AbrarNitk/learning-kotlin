package com.abrark.loginflow.app

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.abrark.loginflow.navigation.PostOfficeRouter
import com.abrark.loginflow.navigation.Screen
import com.abrark.loginflow.screens.LoginScreen
import com.abrark.loginflow.screens.SignUpScreen
import com.abrark.loginflow.screens.TermsAndConditionsScreen

@Composable
fun PostOfficeApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Crossfade(targetState = PostOfficeRouter.currentScreen) { currentState ->
            when(currentState.value) {
                is Screen.TermsAndConditionsScreen -> {
                    TermsAndConditionsScreen()
                }
                is Screen.SignUpScreen -> {
                    SignUpScreen()
                }
                is Screen.LoginScreen -> {
                    LoginScreen()
                }
            }
        }
    }
}