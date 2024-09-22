package com.bisq.bisqeasypoc.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.bisq.bisqeasypoc.ui.theme.primaryColor

@Composable
fun HomeScreen(navController: NavController){
    Scaffold(
        containerColor = primaryColor
    ) { innerPadding ->
        Column (modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
            Text(text = "Welcome to DashBoard", color = Color.White)
        }
    }
}