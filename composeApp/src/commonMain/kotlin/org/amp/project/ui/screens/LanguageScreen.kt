package org.amp.project.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.amp.project.presentation.LanguageViewModel
import org.amp.project.ui.components.language.LanguageLazyColumnComposable
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun LanguageScreen(
    languageViewModel: LanguageViewModel = koinViewModel<LanguageViewModel> { parametersOf() }
) {
    val languageUiState by languageViewModel.uiState.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        LanguageLazyColumnComposable(languageItemList = languageUiState.languages)
    }
}