package com.bisq.bisqeasypoc.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.bisq.bisqeasypoc.R
import com.bisq.bisqeasypoc.screens.words
import com.bisq.bisqeasypoc.ui.theme.nextStepColor
import com.bisq.bisqeasypoc.ui.theme.secondaryColor

@Composable
fun WordsListView() {
    LazyVerticalGrid(
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp),
        contentPadding = PaddingValues(horizontal = 30.dp),
        columns = GridCells.Fixed(2)
    ) {
        items(words) { word ->
            Box(modifier = Modifier.clip(RoundedCornerShape(6.dp))) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .background(color = secondaryColor)
                        .fillMaxSize()
                        .padding(vertical = 12.dp, horizontal = 20.dp)
                ) {
                    Text("${(words.indexOf(word) + 1)}.", color = nextStepColor)
                    Text(
                        word,
                        color = Color.White,
                        modifier = Modifier.padding(start = 10.dp),
                        fontFamily = FontFamily(Font(R.font.ibm_plex_sans_regular))
                    )
                }
            }


        }
    }
}