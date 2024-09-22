package com.bisq.bisqeasypoc.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.bisq.bisqeasypoc.R
import com.bisq.bisqeasypoc.model.AppNavigationConstants.HOME_SCREEN
import com.bisq.bisqeasypoc.model.AppNavigationConstants.ON_BOARDING_SCREEN
import com.bisq.bisqeasypoc.model.AppNavigationConstants.SEED_PHRASE_SCREEN
import com.bisq.bisqeasypoc.ui.theme.nextStepColor
import com.bisq.bisqeasypoc.ui.theme.primaryGreenColor
import com.bisq.bisqeasypoc.ui.theme.secondaryColor
import com.bisq.bisqeasypoc.ui.theme.smallTextColor

@Composable
fun AllWordsAddUpScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Box(
                modifier = Modifier
                    .size(140.dp)
                    .clip(RoundedCornerShape(70))
                    .background(color = primaryGreenColor),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    modifier = Modifier.size(80.dp),
                    imageVector = Icons.Filled.Done,
                    contentDescription = "back icon",
                    tint = Color.White
                )
            }
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = "All words add up!",
                color = Color.White,
                fontFamily = FontFamily(Font(R.font.ibm_plex_sans_light)),
                fontSize = 28.sp,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                modifier = Modifier.width(250.dp),
                text = "ATTENTION: Make sure you save them in a private and secure place.",
                color = Color.White,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily(Font(R.font.ibm_plex_sans_regular))
            )
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "NEXT STEP",
                color = nextStepColor,
                fontFamily = FontFamily(Font(R.font.ibm_plex_sans_regular)),
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                modifier = Modifier.width(250.dp),
                text = "Let's create a trading account so we can buy and sell Bitcoin,",
                color = smallTextColor,
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.ibm_plex_sans_regular))
            )
            Spacer(modifier = Modifier.height(30.dp))
            Button(shape = RoundedCornerShape(2.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp),
                colors = ButtonDefaults.buttonColors(primaryGreenColor),
                onClick = {
                    navController.navigate(HOME_SCREEN) {
                        popUpTo(SEED_PHRASE_SCREEN) { inclusive = true }
                        popUpTo(ON_BOARDING_SCREEN) { inclusive = true }
                    }
                }) {
                Text(
                    text = "Create a Trading Account",
                    color = Color.White,
                    fontFamily = FontFamily(Font(R.font.ibm_plex_sans_regular))
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Button(shape = RoundedCornerShape(2.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp),
                colors = ButtonDefaults.buttonColors(secondaryColor),
                onClick = {
                    navController.navigate(HOME_SCREEN) {
                        popUpTo(SEED_PHRASE_SCREEN) { inclusive = true }
                    }
                }) {
                Text(
                    text = "Create  Trading Account Later",
                    color = Color.White,
                    fontFamily = FontFamily(Font(R.font.ibm_plex_sans_regular))
                )
            }
        }
    }
}