package org.amp.project.ui.components.contact

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import org.amp.project.model.ContactItem

@Composable
fun PhoneMailLazyColumnComposable(
    phoneMailItemList: List<ContactItem>
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ){
        items(phoneMailItemList) {
            PhoneMailItemComposable(phoneMailItem = it)
        }
    }
}