package com.bisq.bisqeasypoc.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.bisq.bisqeasypoc.R
import com.bisq.bisqeasypoc.components.ProgressIndicator
import com.bisq.bisqeasypoc.model.AppNavigationConstants.ON_BOARDING_SCREEN
import com.bisq.bisqeasypoc.model.AppNavigationConstants.SPLASH_SCREEN
import com.bisq.bisqeasypoc.ui.theme.primaryTextColor
import com.bisq.bisqeasypoc.ui.theme.progressColor
import com.bisq.bisqeasypoc.ui.theme.secondaryTextColor
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SplashScreen(navController: NavController) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 80.dp, bottom = 60.dp)
    ) {
        Logo()
        LoadingProgress(navController)
    }
}

@Composable
fun LoadingProgress(navController: NavController) {
    var currentProgress by remember { mutableFloatStateOf(0f) }
    val scope = rememberCoroutineScope()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LaunchedEffect(true) {
            scope.launch {
                loadProgress { progress ->
                    currentProgress = progress
                }
                navController.navigate(ON_BOARDING_SCREEN) {
                    popUpTo(SPLASH_SCREEN) { inclusive = true }
                }
            }
        }
        Text(
            text = "Initializing",
            color = progressColor,
            fontFamily = FontFamily(Font(R.font.ibm_plex_sans_regular))
        )
        ProgressIndicator(
            currentProgress = currentProgress,
            modifier = Modifier
                .fillMaxWidth()
                .padding(40.dp, 20.dp)
                .height(2.dp),
            trackColor = progressColor

        )
        Text(text = "Connecting to Tor Network...", color = primaryTextColor)

    }
}

suspend fun loadProgress(updateProgress: (Float) -> Unit) {
    for (i in 1..100) {
        updateProgress(i.toFloat() / 100)
        delay(60)
    }
}

@Preview
@Composable
fun Logo() {
    Column(
        //modifier = Modifier.size(200.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.size(180.dp, 80.dp),
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null
        )
        Text(
            // modifier = Modifier.padding(top = 0.dp),
            text = "Exchange, Decentralized",
            color = secondaryTextColor,
            fontSize = 14.sp,
        )
    }
}

