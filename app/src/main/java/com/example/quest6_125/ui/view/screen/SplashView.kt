package com.example.quest6_125.ui.view.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


@Composable
fun SplashView(
    onMulaiButton: ()-> Unit,
){
    val R = null
    Column(
        modifier = Modifier.fillMaxSize().background(color = colorResource(id = R.colors.primary)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = R.drawable.logoumy), contentDescription = "", modifier = Modifier.size(150.dp))
        Spacer(modifier = Modifier.padding(32.dp))
        Button(onClick = onMulaiButton) {
            Text(text = "Mulai")
        }
    }
}