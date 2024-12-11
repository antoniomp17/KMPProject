package org.amp.project.ui.main.layouts

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import org.amp.project.data.utils.TopBarTypes
import org.amp.project.navigation.Navigation
import org.amp.project.navigation.NavigationScreens
import org.amp.project.presentation.ContactUiState
import org.amp.project.presentation.JobExperienceUiState
import org.amp.project.presentation.LanguageUiState
import org.amp.project.presentation.ResumeItemUiState
import org.amp.project.presentation.SkillUiState
import org.amp.project.ui.components.mainLayout.common.TopAppBar
import org.amp.project.ui.components.mainLayout.medium.CustomNavigationRail
import org.amp.project.ui.screens.ResumeScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExpandedLayout(
    navigator: NavHostController,
    topBarType: TopBarTypes,
    scrollBehavior: TopAppBarScrollBehavior,
    jobExperienceUiState: JobExperienceUiState,
    resumeItemUiState: ResumeItemUiState,
    contactUiState: ContactUiState,
    languageUiState: LanguageUiState,
    skillUiState: SkillUiState
) {
    Scaffold(
        modifier = Modifier.fillMaxSize().nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {

            TopAppBar(
                topBarType = topBarType,
                navigator = navigator,
                scrollBehavior = scrollBehavior
            )
        }
    ) { paddingValues ->
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            CustomNavigationRail(navigator)
            Box(
                modifier = Modifier
                    .weight(2f)
                    .padding(horizontal = 16.dp)
            ) {
                ResumeScreen(
                    jobExperienceUiState = jobExperienceUiState,
                    resumeItemUiState = resumeItemUiState,
                    onJobExperienceClick = { jobExperience ->
                        navigator.navigate(NavigationScreens.JobExperience.createRoute(jobExperience.id))
                    },
                    onResumeItemClick = {}
                )
            }
            Box(
                modifier = Modifier
                    .weight(3f)
                    .padding(horizontal = 16.dp)
            ) {
                if (navigator.currentBackStackEntry?.destination?.route != "/home") {
                    Navigation(
                        navController = navigator,
                        jobExperienceUiState = jobExperienceUiState,
                        resumeItemUiState = resumeItemUiState,
                        contactUiState = contactUiState,
                        languageUiState = languageUiState,
                        skillUiState = skillUiState
                    )
                }
            }
        }
    }
}