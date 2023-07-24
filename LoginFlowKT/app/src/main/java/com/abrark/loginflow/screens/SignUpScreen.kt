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
import com.abrark.loginflow.components.CheckBoxComponent
import com.abrark.loginflow.components.ClickableLoginTextComponent
import com.abrark.loginflow.components.DividerTextComponent
import com.abrark.loginflow.components.HeadingComponent
import com.abrark.loginflow.components.NormalTextComponent
import com.abrark.loginflow.components.PasswordTextField
import com.abrark.loginflow.components.TextField
import com.abrark.loginflow.navigation.PostOfficeRouter
import com.abrark.loginflow.navigation.Screen

@Composable
fun SignUpScreen() {
    Surface(
        color = Color.White,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            NormalTextComponent(value = stringResource(id = R.string.hello))
            HeadingComponent(value = stringResource(id = R.string.create_account))
            Spacer(modifier = Modifier.height(20.dp))
            TextField(labelValue = stringResource(id = R.string.first_name), painterResource(id = R.drawable.profile))
            TextField(labelValue = stringResource(id = R.string.last_name), painterResource(id = R.drawable.profile))
            TextField(labelValue = stringResource(id = R.string.email), painterResource(id = R.drawable.message))
            PasswordTextField(labelValue = stringResource(id = R.string.password), painterResource(id = R.drawable.lock))
            CheckBoxComponent(value = "By clicking you are agreeing the terms and condition of use") {clicktedText ->
                PostOfficeRouter.navigateTo(Screen.TermsAndConditionsScreen)
            }
            Spacer(modifier = Modifier.height(40.dp))
            ButtonComponent(value = stringResource(id = R.string.register))
            Spacer(modifier = Modifier.height(20.dp))
            DividerTextComponent()
            Spacer(modifier = Modifier.height(20.dp))
            ClickableLoginTextComponent(isLogin = true) {clickedText ->
                PostOfficeRouter.navigateTo(Screen.LoginScreen)
            }
        }
    }
}

@Preview
@Composable
fun DefaultPreviewOfSignUpScreen() {
    SignUpScreen()
}