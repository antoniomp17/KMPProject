package org.amp.project.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import composeResources.Res
import composeResources.experience
import composeResources.personal_projects
import org.jetbrains.compose.resources.stringResource

@Composable
fun ResumeScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ){
        Text(
            style = MaterialTheme.typography.titleMedium,
            text = stringResource(Res.string.experience)
        )
        ExperienceComposable(listOf("Text", "Text", "Text"))

        HorizontalDivider()

        Text(
            style = MaterialTheme.typography.titleMedium,
            text = stringResource(Res.string.personal_projects)
        )
        ResumeLazyColumn(listOf("Text"))
    }

}