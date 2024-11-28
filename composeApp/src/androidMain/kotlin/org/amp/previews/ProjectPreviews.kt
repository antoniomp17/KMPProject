package org.amp.previews

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.amp.project.data.JobExperienceManager
import org.amp.project.presentation.JobExperienceUiState
import org.amp.project.ui.ResumeItem
import org.amp.project.ui.ResumeScreen
import org.amp.project.ui.theme.AppTheme

@Preview(showBackground = true)
@Composable
fun ResumeScreenPreview() {
    AppTheme {
        Box(modifier = Modifier.padding(8.dp).fillMaxSize()) {
            ResumeScreen(
                uiState = JobExperienceUiState(
                    jobExperiences = JobExperienceManager.fakeJobExperienceList
                ),
                onJobExperienceClick = {}
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ResumeItemPreview() {
    AppTheme {
        Box(modifier = Modifier.padding(8.dp).fillMaxSize()) {
            ResumeItem("Text")
        }
    }
}