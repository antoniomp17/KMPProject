package org.amp.project.ui.utils

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun <T> ResponsiveLazyGrid(
    items: List<T>,
    modifier: Modifier = Modifier,
    itemMinWidth: Dp = 120.dp,
    contentPadding: PaddingValues = PaddingValues(8.dp),
    state: LazyGridState = rememberLazyGridState(),
    itemContent: @Composable (item: T) -> Unit
) {
    BoxWithConstraints(modifier = modifier) {

        val columnCount = calculateColumns(maxWidth, itemMinWidth)

        LazyVerticalGrid(
            columns = GridCells.Fixed(columnCount),
            state = state,
            contentPadding = contentPadding
        ) {
            items(items) { item ->
                itemContent(item)
            }
        }
    }
}

private fun calculateColumns(maxWidth: Dp, itemMinWidth: Dp): Int {
    val totalColumns = (maxWidth / itemMinWidth).toInt()
    return totalColumns.coerceAtLeast(1)
}