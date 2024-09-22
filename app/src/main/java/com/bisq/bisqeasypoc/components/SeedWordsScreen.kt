package com.bisq.bisqeasypoc.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bisq.bisqeasypoc.R
import com.bisq.bisqeasypoc.ui.theme.primaryGreenColor
import com.bisq.bisqeasypoc.ui.theme.secondaryColor

@Composable
fun SeedWordsScreen(goToNext: (Boolean, Float) -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = "Seed Words",
                color = Color.White,
                fontFamily = FontFamily(Font(R.font.ibm_plex_sans_light)),
                fontSize = 25.sp
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                modifier = Modifier.width(250.dp),
                text = "Write down the words below and store theme in a safe, personal place.",
                color = Color.White,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily(Font(R.font.ibm_plex_sans_regular))
            )
            Spacer(modifier = Modifier.height(34.dp))
            WordsListView()
        }

        Column {
            Button(shape = RoundedCornerShape(2.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp),
                colors = ButtonDefaults.buttonColors(primaryGreenColor),
                onClick = { goToNext(false, 2f) }
            ) {
                Text(
                    text = "Confirm Seed Words",
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
                onClick = { }) {
                Text(
                    text = "Backup Seed Words Later",
                    color = Color.White,
                    fontFamily = FontFamily(Font(R.font.ibm_plex_sans_regular))
                )
            }
        }
    }
}
