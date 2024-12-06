package org.amp.project.ui.components.language

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import org.amp.project.model.LanguageItem

@Composable
fun LanguageLazyColumnComposable(
    languageItemList: List<LanguageItem>
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ){
        items(languageItemList) {
            LanguageItemComposable(languageItem = it)
        }
    }
}