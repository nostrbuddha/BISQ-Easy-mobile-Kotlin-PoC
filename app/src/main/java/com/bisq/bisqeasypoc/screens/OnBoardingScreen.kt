package com.bisq.bisqeasypoc.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.LocalOverscrollConfiguration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.bisq.bisqeasypoc.R
import com.bisq.bisqeasypoc.model.AppNavigationConstants.HOME_SCREEN
import com.bisq.bisqeasypoc.model.AppNavigationConstants.ON_BOARDING_SCREEN
import com.bisq.bisqeasypoc.model.AppNavigationConstants.SEED_PHRASE_SCREEN
import com.bisq.bisqeasypoc.model.OnBoardingPage
import com.bisq.bisqeasypoc.ui.theme.indicatorTrackColor
import com.bisq.bisqeasypoc.ui.theme.paragraphColor
import com.bisq.bisqeasypoc.ui.theme.primaryColor
import com.bisq.bisqeasypoc.ui.theme.primaryGreenColor
import com.bisq.bisqeasypoc.ui.theme.secondaryColor
import com.bisq.bisqeasypoc.ui.theme.smallTextColor
import com.bisq.bisqeasypoc.util.dpToPx
import com.bisq.bisqeasypoc.util.slidingLineTransition

@Composable
fun OnBoardingScreen(navController: NavController) {
    Scaffold(
        containerColor = primaryColor,
    ) { innerPadding ->
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(top = 50.dp, bottom = 20.dp)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Welcome to BISQ",
                    fontSize = 25.sp,
                    color = Color.White,
                    fontFamily = FontFamily(Font(R.font.ibm_plex_sans_light))
                )
                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    lineHeight = 1.5.em,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 32.dp),
                    text = "Now that you are connected to the network, you need to go through a few of steps before initiating your first trade",
                    textAlign = TextAlign.Center,
                    color = paragraphColor,
                    fontFamily = FontFamily(Font(R.font.ibm_plex_sans_regular))
                )
            }

            PagerView(navController)
            Column {
                Button(
                    shape = RoundedCornerShape(2.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 30.dp),
                    colors = ButtonDefaults.buttonColors(primaryGreenColor),
                    onClick = { navController.navigate(SEED_PHRASE_SCREEN) }
                ) {
                    Text(text = "Get Started", color = Color.White, fontFamily =  FontFamily(Font(R.font.ibm_plex_sans_regular)))
                }
                Spacer(modifier = Modifier.height(20.dp))
                Button(
                    shape = RoundedCornerShape(2.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 30.dp),
                    colors = ButtonDefaults.buttonColors(secondaryColor),
                    onClick = {
                        navController.navigate(HOME_SCREEN) {
                            popUpTo(ON_BOARDING_SCREEN) { inclusive = true }
                        }
                    }) {
                    Text(text = "Skip Initial Setup", color = Color.White, fontFamily = FontFamily(Font(R.font.ibm_plex_sans_regular)))
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PagerView(navController: NavController) {

    val list = listOf(
        OnBoardingPage(
            title = "Fund Security Deposit",
            image = R.drawable.sl01
        ),
        OnBoardingPage(
            title = "Protect Your Wallet",
            image = R.drawable.sl02
        ),
        OnBoardingPage(
            title = "Backup Seed Words",
            image = R.drawable.sl03
        ),
        OnBoardingPage(
            title = "Create Trading Account",
            image = R.drawable.sl04
        ),
    )

    val pagerState = rememberPagerState(pageCount = { list.size })

    CompositionLocalProvider(LocalOverscrollConfiguration provides null) {
        Column (
            verticalArrangement = Arrangement.spacedBy(30.dp,Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HorizontalPager(
                pageSpacing = 24.dp,
                contentPadding = PaddingValues(horizontal = 80.dp),
                pageSize = PageSize.Fill,
                verticalAlignment = Alignment.CenterVertically,
                state = pagerState
            ) { index ->
                list.getOrNull(
                    index % (list.size)
                )?.let { item ->
                    BannerItem(
                        image = item.image,
                        title = item.title,
                        pageNumber = index + 1,
                        navController = navController
                    )
                }
            }
            LineIndicator(pagerState = pagerState)
        }
    }
}

@Composable
fun BannerItem(pageNumber: Int, title: String, image: Int, navController: NavController) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .clickable(
                indication = null,
                interactionSource = remember {
                    MutableInteractionSource()
                },
                enabled = pageNumber == 3,
                onClick = { navController.navigate(SEED_PHRASE_SCREEN) }),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .fillMaxWidth()
                .height((LocalContext.current.resources.displayMetrics.heightPixels/5).dp)
                .background(color = secondaryColor)
                .padding(vertical = 20.dp)
        ) {
            Text(
                fontFamily = FontFamily(Font(R.font.ibm_plex_sans_thin)),
                fontSize = 34.sp,
                text = pageNumber.toString(),
                color = Color.White
            )
            Image(
                modifier = Modifier.size(150.dp),
                painter = painterResource(id = image),
                contentDescription = null
            )
            Text(
                text = title,
                color = smallTextColor,
                fontFamily = FontFamily(Font(R.font.ibm_plex_sans_regular))
            )
        }
    }
}

@Composable
fun LineIndicator(pagerState: PagerState) {
    Box(
        contentAlignment = Alignment.CenterStart
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            repeat(pagerState.pageCount) {
                Box(
                    modifier = Modifier
                        .size(width = 30.dp, height = 2.dp)
                        .background(
                            color = indicatorTrackColor,
                        )
                )
            }
        }
        Box(
            Modifier
                .slidingLineTransition(
                    pagerState,
                    30.dpToPx(LocalContext.current)
                )
                .size(width = 40.dp, height = 3.dp)
                .background(
                    color = primaryGreenColor,
                    shape = RoundedCornerShape(3.dp),
                )
        )
    }
}
