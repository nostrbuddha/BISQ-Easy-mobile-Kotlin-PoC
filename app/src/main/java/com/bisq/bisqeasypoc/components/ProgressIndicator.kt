package com.bisq.bisqeasypoc.components

import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.ProgressIndicatorDefaults.drawStopIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.bisq.bisqeasypoc.ui.theme.primaryGreenColor
import com.bisq.bisqeasypoc.ui.theme.progressColor

@Composable
fun ProgressIndicator(currentProgress: Float, modifier: Modifier, trackColor: Color) {
    LinearProgressIndicator(
        trackColor = trackColor,
        color = primaryGreenColor,
        progress = { currentProgress },
        gapSize = 0.dp,
        modifier = modifier,
        drawStopIndicator = {
            drawStopIndicator(
                drawScope = this,
                stopSize = 0.dp,
                color = progressColor,
                strokeCap = ProgressIndicatorDefaults.LinearStrokeCap
            )
        }
    )
}