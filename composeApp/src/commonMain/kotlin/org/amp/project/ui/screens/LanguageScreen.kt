package org.amp.project.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import composeResources.Res
import composeResources.languages
import org.amp.project.presentation.LanguageUiState
import org.amp.project.ui.components.language.LanguageLazyColumnComposable
import org.jetbrains.compose.resources.stringResource

@Composable
fun LanguageScreen(languageUiState: LanguageUiState){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        LanguageLazyColumnComposable(languageItemList = languageUiState.languages)
    }
}