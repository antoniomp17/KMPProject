package org.amp.project.ui.main.layouts

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.navigation.NavHostController
import org.amp.project.data.utils.TopBarTypes
import org.amp.project.navigation.Navigation
import org.amp.project.ui.components.mainLayout.common.TopAppBar
import org.amp.project.ui.components.mainLayout.compact.NavigationDrawerContent
import org.amp.project.presentation.ContactUiState
import org.amp.project.presentation.JobExperienceUiState
import org.amp.project.presentation.LanguageUiState
import org.amp.project.presentation.ResumeItemUiState
import org.amp.project.presentation.SkillUiState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CompactLayout(
    navigator: NavHostController,
    topBarType: TopBarTypes,
    scrollBehavior: TopAppBarScrollBehavior,
    jobExperienceUiState: JobExperienceUiState,
    resumeItemUiState: ResumeItemUiState,
    contactUiState: ContactUiState,
    languageUiState: LanguageUiState,
    skillUiState: SkillUiState
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            NavigationDrawerContent(
                drawerState = drawerState,
                onLanguageClick = { navigator.navigate("/languages") },
                onContactClick = { navigator.navigate("/contact") },
                onSkillsClick = { navigator.navigate("/skills") }
            )
        }
    ) {
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .nestedScroll(scrollBehavior.nestedScrollConnection),
            topBar = {
                TopAppBar(
                    topBarType = topBarType,
                    drawerState = drawerState,
                    scope = scope,
                    navigator = navigator,
                    scrollBehavior = scrollBehavior
                )
            }
        ) { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
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