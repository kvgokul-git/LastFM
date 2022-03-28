package com.lastfm.app.ui.views.reusable_views

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil.compose.rememberImagePainter
import com.lastfm.app.R

@OptIn(coil.annotation.ExperimentalCoilApi::class)
@Composable
fun CoilImage(
    url: String,
    contentDescription: String?,
    modifier: Modifier = Modifier
) {
    val painter = rememberImagePainter(
        data = url,
        builder = {
            crossfade(true)
            placeholder(R.drawable.image_place_holder)
        }
    )
    Image(
        painter = painter,
        contentDescription = contentDescription,
        modifier = modifier
    )
}
