package com.bisq.bisqeasypoc.util

import android.content.Context
import androidx.compose.foundation.pager.PagerState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer

fun Modifier.slidingLineTransition(pagerState: PagerState, distance: Float) =
    graphicsLayer {
        val scrollPosition = pagerState.currentPage + pagerState.currentPageOffsetFraction
        translationX = scrollPosition * distance
    }

fun Int.dpToPx(context: Context): Float = (this * context.resources.displayMetrics.density)