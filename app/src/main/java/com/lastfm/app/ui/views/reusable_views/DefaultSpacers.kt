package com.lastfm.app.ui.views.reusable_views

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun XXSmallSpacer() = Spacer(4.dp)

@Composable
fun XSmallSpacer() = Spacer(8.dp)

@Composable
fun SmallSpacer() = Spacer(16.dp)

@Composable
fun MediumSpacer() = Spacer(24.dp)

@Composable
fun LargeSpacer() = Spacer(32.dp)

@Composable
fun XLargeSpacer() = Spacer(40.dp)

@Composable
fun Spacer(height: Dp) = Spacer(
    modifier = Modifier
        .height(height)
        .fillMaxWidth()
)
