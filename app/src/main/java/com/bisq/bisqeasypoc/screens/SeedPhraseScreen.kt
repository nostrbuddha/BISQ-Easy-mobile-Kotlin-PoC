package com.bisq.bisqeasypoc.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.bisq.bisqeasypoc.components.AllWordsAddUpScreen
import com.bisq.bisqeasypoc.components.ProgressIndicator
import com.bisq.bisqeasypoc.components.SeedWordQueryScreen
import com.bisq.bisqeasypoc.components.SeedWordsScreen
import com.bisq.bisqeasypoc.components.SomethingOffScreen
import com.bisq.bisqeasypoc.ui.theme.primaryColor
import com.bisq.bisqeasypoc.ui.theme.progressColor
import com.bisq.bisqeasypoc.ui.theme.progressSecondaryColor

val words = listOf(
    "witch",
    "collapse",
    "shame",
    "open",
    "road",
    "again",
    "open",
    "shame",
    "ice",
    "despair",
    "creek",
    "least"
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SeedPhraseScreen(navController: NavController) {

    var isSeedWordsVisible by remember { mutableStateOf(true) }
    var isSomethingOffVisible by remember { mutableStateOf(false) }
    var isSuccessVisible by remember { mutableStateOf(false) }
    var currentProgress by remember { mutableFloatStateOf(1f) }

    Scaffold(
        containerColor = primaryColor,
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    titleContentColor = Color.White,
                    navigationIconContentColor = progressColor,
                    containerColor = primaryColor
                ), title = {
                    Text(
                        "3. Backup Bitcoin Seed Phrase",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        fontSize = 20.sp
                    )
                }, navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            modifier = Modifier.size(34.dp),
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                            contentDescription = "back icon"
                        )
                    }
                }
            )
        }) { innerPadding ->
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            ProgressIndicator(
                currentProgress = ((LocalContext.current.resources.displayMetrics.widthPixels / 30) * currentProgress) / 100F,
                trackColor = progressSecondaryColor,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(2.dp)
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.padding(top = 34.dp, bottom = 20.dp),
            ) {
                when {
                    isSeedWordsVisible -> SeedWordsScreen { isSeedWordsShow, currentPage ->
                        isSeedWordsVisible = isSeedWordsShow
                        currentProgress = currentPage
                    }

                    isSuccessVisible -> AllWordsAddUpScreen(navController = navController)

                    isSomethingOffVisible -> SomethingOffScreen { isSomethingOffShow, currentPage ->
                        isSeedWordsVisible = isSomethingOffShow
                        isSomethingOffVisible = !isSomethingOffShow
                        currentProgress = currentPage
                    }

                    else -> SeedWordQueryScreen { seedQueryResult, currentPage ->
                        isSuccessVisible = seedQueryResult
                        isSomethingOffVisible = !seedQueryResult
                        currentProgress = currentPage
                    }
                }
            }
        }
    }
}


