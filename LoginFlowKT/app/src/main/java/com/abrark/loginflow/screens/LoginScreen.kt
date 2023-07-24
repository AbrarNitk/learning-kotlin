package com.abrark.loginflow.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abrark.loginflow.R
import com.abrark.loginflow.components.ButtonComponent
import com.abrark.loginflow.components.ClickableLoginTextComponent
import com.abrark.loginflow.components.DividerTextComponent
import com.abrark.loginflow.components.HeadingComponent
import com.abrark.loginflow.components.NormalTextComponent
import com.abrark.loginflow.components.PasswordTextField
import com.abrark.loginflow.components.TextField
import com.abrark.loginflow.components.UnderlinedTextComponent
import com.abrark.loginflow.navigation.PostOfficeRouter
import com.abrark.loginflow.navigation.Screen
import com.abrark.loginflow.navigation.SystemBackButtonHandler

@Composable
fun LoginScreen() {
    Surface(
        color = Color.White,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            NormalTextComponent(value = stringResource(id = R.string.hello))
            HeadingComponent(value = stringResource(id = R.string.welcome))
            Spacer(modifier = Modifier.height(20.dp))
            TextField(labelValue = stringResource(id = R.string.email), painterResource(id = R.drawable.message))
            PasswordTextField(labelValue = stringResource(id = R.string.password), painterResource(id = R.drawable.lock))
            Spacer(modifier = Modifier.height(20.dp))
            UnderlinedTextComponent(value = stringResource(id = R.string.forget_pass))
            Spacer(modifier = Modifier.height(20.dp))
            ButtonComponent(value = stringResource(id = R.string.login))
            Spacer(modifier = Modifier.height(20.dp))
            DividerTextComponent()
            ClickableLoginTextComponent(isLogin = false) {clickedText ->
                PostOfficeRouter.navigateTo(Screen.SignUpScreen)
            }
        }
    }

    SystemBackButtonHandler {
        PostOfficeRouter.navigateTo(Screen.SignUpScreen)
    }
}


@Preview
@Composable fun LoginScreenPreview() {
    LoginScreen()
}