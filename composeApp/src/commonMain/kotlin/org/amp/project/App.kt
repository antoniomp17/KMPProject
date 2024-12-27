package org.amp.project

import androidx.compose.runtime.Composable
import org.amp.project.ui.AppContent
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext

@Composable
@Preview
fun App() {
    KoinContext {
        AppContent()
    }
}