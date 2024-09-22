package com.bisq.bisqeasypoc.model

data class OnBoardingPage(val title: String, val image: Int)

object AppNavigationConstants {
    const val SPLASH_SCREEN = "splashScreen"
    const val ON_BOARDING_SCREEN = "onBoardingScreen"
    const val SEED_PHRASE_SCREEN = "seedPhraseScreen"
    const val HOME_SCREEN = "homeScreen"
}