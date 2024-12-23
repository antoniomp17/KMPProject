package org.amp.project.ui.screens

import androidx.compose.runtime.Composable
import org.amp.project.data.utils.isWeb
import org.amp.project.presentation.ThemeUiState
import org.amp.project.ui.components.download.DownloadContent

@Composable
actual fun DownloadScreen(themeUiState: ThemeUiState,) {
    DownloadContent(
        isWeb = isWeb(),
        themeUiState = themeUiState
    )
}