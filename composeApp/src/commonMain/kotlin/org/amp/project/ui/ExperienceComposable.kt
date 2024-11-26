package org.amp.project.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ExperienceComposable() {

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ){
        stickyHeader {
            Column {
                //compose elements
            }
        }
        items(emptyList<String>()) {
            //compose elements
        }
    }
}