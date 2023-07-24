package com.abrark.loginflow.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abrark.loginflow.R
import com.abrark.loginflow.components.HeadingComponent
import com.abrark.loginflow.navigation.PostOfficeRouter
import com.abrark.loginflow.navigation.Screen
import com.abrark.loginflow.navigation.SystemBackButtonHandler

@Composable
fun TermsAndConditionsScreen() {
    Surface(modifier = Modifier
        .fillMaxSize()
        .background(color = colorResource(id = R.color.colorWhite))
        .padding(16.dp)
    ) {
        HeadingComponent(value = stringResource(id = R.string.tnc_heading))
    }
    SystemBackButtonHandler {
        PostOfficeRouter.navigateTo(Screen.SignUpScreen)
    }
}

@Preview
@Composable
fun TermsAndConditionsScreenPreview() {
    TermsAndConditionsScreen()
}
