package org.amp.project.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.amp.project.presentation.SkillUiState
import org.amp.project.presentation.ThemeUiState
import org.amp.project.ui.components.skill.SkillLazyGridComposable

@Composable
fun SkillScreen(skillUiState: SkillUiState,
                themeUiState: ThemeUiState
){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        SkillLazyGridComposable(
            skillItemList = skillUiState.skills,
            themeUiState = themeUiState
        )
    }
}