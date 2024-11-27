package org.amp.project

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import moe.tlaster.precompose.PreComposeApp
import org.amp.project.ui.ResumeScreen
import org.amp.project.ui.theme.AppTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    PreComposeApp{
        AppTheme {
            ResumeScreen()
        }
    }
}