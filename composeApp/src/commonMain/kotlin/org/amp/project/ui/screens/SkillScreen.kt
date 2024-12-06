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
import composeResources.skills
import org.amp.project.presentation.SkillUiState
import org.amp.project.ui.components.skill.SkillLazyGridComposable
import org.jetbrains.compose.resources.stringResource

@Composable
fun SkillScreen(skillUiState: SkillUiState){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 32.dp),
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        Text(
            text = stringResource(Res.string.skills),
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            letterSpacing = 0.5.sp
        )
        SkillLazyGridComposable(skillItemList = skillUiState.skills)
    }
}