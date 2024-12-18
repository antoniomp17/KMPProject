package org.amp.project.ui.components.contact

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.amp.project.model.ContactItem

@Composable
fun PhoneMailLazyColumnComposable(
    phoneMailItemList: List<ContactItem>
) {
    BoxWithConstraints(
        modifier = Modifier.fillMaxSize()
    ) {
        val width = maxWidth

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .sizeIn(
                    maxHeight = (phoneMailItemList.size * width.value / 4.4f).dp
                )
                .fillMaxWidth()
                .aspectRatio(4.4f / phoneMailItemList.size),
            userScrollEnabled = false
        ) {
            items(phoneMailItemList) {
                PhoneMailItemComposable(phoneMailItem = it)
            }
        }
    }
}