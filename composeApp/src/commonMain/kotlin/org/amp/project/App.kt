package org.amp.project

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import moe.tlaster.precompose.PreComposeApp
import moe.tlaster.precompose.viewmodel.viewModel
import org.amp.project.data.JobExperienceManager
import org.amp.project.data.JobExperienceRepositoryImpl
import org.amp.project.data.ResumeItemManager
import org.amp.project.data.ResumeItemRepositoryImpl
import org.amp.project.presentation.JobExperienceViewModel
import org.amp.project.presentation.ResumeItemViewModel
import org.amp.project.ui.ResumeScreen
import org.amp.project.ui.theme.AppTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    PreComposeApp{
        /*
        AppTheme {
            ResumeScreen(
                jobExperienceUiState = jobExperienceUiState,
                resumeItemUiState = resumeItemUiState,
                onJobExperienceClick = {},
                onResumeItemClick = {}
            )
        }

         */
    }
}