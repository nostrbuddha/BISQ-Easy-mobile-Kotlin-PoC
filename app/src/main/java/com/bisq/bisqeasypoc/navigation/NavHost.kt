package com.bisq.bisqeasypoc.navigation

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bisq.bisqeasypoc.model.AppNavigationConstants.HOME_SCREEN
import com.bisq.bisqeasypoc.model.AppNavigationConstants.ON_BOARDING_SCREEN
import com.bisq.bisqeasypoc.model.AppNavigationConstants.SEED_PHRASE_SCREEN
import com.bisq.bisqeasypoc.model.AppNavigationConstants.SPLASH_SCREEN
import com.bisq.bisqeasypoc.screens.HomeScreen
import com.bisq.bisqeasypoc.screens.OnBoardingScreen
import com.bisq.bisqeasypoc.screens.SeedPhraseScreen
import com.bisq.bisqeasypoc.screens.SplashScreen
import com.bisq.bisqeasypoc.ui.theme.primaryColor

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        modifier = Modifier.background(color = primaryColor),
        navController = navController,
        startDestination = SPLASH_SCREEN
    ) {
        composable(SPLASH_SCREEN) { SplashScreen(navController) }
        composable(ON_BOARDING_SCREEN) { OnBoardingScreen(navController) }
        composable(SEED_PHRASE_SCREEN) { SeedPhraseScreen(navController) }
        composable(HOME_SCREEN) { HomeScreen(navController) }
    }
}

