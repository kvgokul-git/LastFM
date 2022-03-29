package com.lastfm.app.ui.views.reusable_views

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PageHeader(heading: String?) {
    heading?.let {
        Text(
            text = it,
            style = MaterialTheme.typography.h6,
            modifier = Modifier
                .padding(horizontal = 16.dp)
        )
    }
}

@Composable
fun TextName(name: String?) {
    name?.let {
        Text(
            text = it,
            style = MaterialTheme.typography.caption,
            modifier = Modifier
                .padding(horizontal = 16.dp)
        )
    }
}
