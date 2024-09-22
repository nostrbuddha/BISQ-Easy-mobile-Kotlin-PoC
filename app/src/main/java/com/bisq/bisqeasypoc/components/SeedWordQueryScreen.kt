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
import com.bisq.bisqeasypoc.screens.words
import com.bisq.bisqeasypoc.ui.theme.secondaryColor

@Composable
fun SeedWordQueryScreen(goToNext: (Boolean, Float) -> Unit){
    val position = words.indexOf(words.random()) + 1
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(

            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                modifier = Modifier.width(280.dp),
                text = "What is the seed word in position $position?",
                color = Color.White,
                fontFamily = FontFamily(Font(R.font.ibm_plex_sans_light)),
                fontSize = 28.sp,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(40.dp))
            Column(
                modifier = Modifier.padding(horizontal = 30.dp),
                verticalArrangement = Arrangement.spacedBy(
                    20.dp, alignment = Alignment.CenterVertically
                )
            ) {
                Button(shape = RoundedCornerShape(2.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp),
                    colors = ButtonDefaults.buttonColors(secondaryColor),
                    onClick = { goToNext(words[0] == words[position - 1],3f) }) {
                    Text(
                        text = words[0],
                        color = Color.White,
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(R.font.ibm_plex_sans_regular))
                    )
                }

                Button(shape = RoundedCornerShape(2.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp),
                    colors = ButtonDefaults.buttonColors(secondaryColor),
                    onClick = { goToNext(words[position - 1] == words[position - 1],3f) }) {
                    Text(
                        text = words[position - 1],
                        color = Color.White,
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(R.font.ibm_plex_sans_regular))
                    )
                }

                Button(shape = RoundedCornerShape(2.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp),
                    colors = ButtonDefaults.buttonColors(secondaryColor),
                    onClick = { goToNext(words[5] == words[position - 1],3f) }) {
                    Text(
                        text = words[5],
                        color = Color.White,
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(R.font.ibm_plex_sans_regular))
                    )
                }


            }

        }
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