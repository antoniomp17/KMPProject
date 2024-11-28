package org.amp.project

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import moe.tlaster.precompose.PreComposeApp
import moe.tlaster.precompose.viewmodel.viewModel
import org.amp.project.data.JobExperienceManager
import org.amp.project.data.JobExperienceRepositoryImpl
import org.amp.project.presentation.JobExperienceViewModel
import org.amp.project.ui.ResumeScreen
import org.amp.project.ui.theme.AppTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    PreComposeApp{

        val viewModel = viewModel(modelClass = JobExperienceViewModel::class) {
            JobExperienceViewModel(repo = JobExperienceRepositoryImpl(JobExperienceManager))
        }
        val uiState by viewModel.uiState.collectAsStateWithLifecycle()

        AppTheme {
            ResumeScreen(
                uiState = uiState,
                onJobExperienceClick = {}
            )
        }
    }
}