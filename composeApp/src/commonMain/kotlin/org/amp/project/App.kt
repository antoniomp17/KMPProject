package org.amp.project

import androidx.compose.runtime.Composable
import org.amp.project.ui.AppContent
import org.amp.project.ui.theme.AppTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    AppTheme {
        AppContent()
    }
}