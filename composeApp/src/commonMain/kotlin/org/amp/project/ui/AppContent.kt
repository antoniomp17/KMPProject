package org.amp.project.ui

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import org.amp.project.data.contact.ContactManager
import org.amp.project.data.contact.ContactRepositoryImpl
import org.amp.project.data.jobExperience.JobExperienceManager
import org.amp.project.data.jobExperience.JobExperienceRepositoryImpl
import org.amp.project.data.language.LanguageManager
import org.amp.project.data.language.LanguageRepositoryImpl
import org.amp.project.data.otherResume.OtherOtherResumeItemRepositoryImpl
import org.amp.project.data.otherResume.OtherResumeItemManager
import org.amp.project.data.skill.SkillManager
import org.amp.project.data.skill.SkillRepositoryImpl
import org.amp.project.data.utils.WindowSizeClass
import org.amp.project.presentation.ContactViewModel
import org.amp.project.presentation.JobExperienceViewModel
import org.amp.project.presentation.LanguageViewModel
import org.amp.project.presentation.ResumeItemViewModel
import org.amp.project.presentation.SkillViewModel
import org.amp.project.ui.layouts.CompactLayout
import org.amp.project.ui.layouts.ExpandedLayout
import org.amp.project.ui.layouts.MediumLayout
import org.amp.project.ui.utils.GetTopBarType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppContent() {
    val navigator = rememberNavController()
    val topBarType = GetTopBarType(navigator)
    val density = LocalDensity.current

    val jobExperienceViewModel = viewModel{
        JobExperienceViewModel(
            JobExperienceRepositoryImpl(
                JobExperienceManager
            )
        )
    }
    val resumeItemViewModel = viewModel{
        ResumeItemViewModel(
            OtherOtherResumeItemRepositoryImpl(
                OtherResumeItemManager
            )
        )
    }
    val contactViewModel = viewModel{
        ContactViewModel(
            ContactRepositoryImpl(
                ContactManager
            )
        )
    }
    val languageViewModel = viewModel{
        LanguageViewModel(
            LanguageRepositoryImpl(
                LanguageManager
            )
        )
    }
    val skillViewModel = viewModel{
        SkillViewModel(
            SkillRepositoryImpl(
                SkillManager
            )
        )
    }

    val jobExperienceUiState by jobExperienceViewModel.uiState.collectAsStateWithLifecycle()
    val resumeItemUiState by resumeItemViewModel.uiState.collectAsStateWithLifecycle()
    val contactUiState by contactViewModel.uiState.collectAsStateWithLifecycle()
    val languageUiState by languageViewModel.uiState.collectAsStateWithLifecycle()
    val skillUiState by skillViewModel.uiState.collectAsStateWithLifecycle()


    BoxWithConstraints {

        val screenWidthDp = with(density) {  constraints.maxWidth.toDp() }

        val windowSize = when {
            screenWidthDp < 600.dp -> WindowSizeClass.COMPACT
            screenWidthDp < 840.dp -> WindowSizeClass.MEDIUM
            else -> WindowSizeClass.EXPANDED
        }

        when (windowSize) {
            WindowSizeClass.COMPACT -> {
                CompactLayout(
                    navigator = navigator,
                    topBarType = topBarType,
                    scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(),
                    jobExperienceUiState = jobExperienceUiState,
                    resumeItemUiState = resumeItemUiState,
                    contactUiState = contactUiState,
                    languageUiState = languageUiState,
                    skillUiState = skillUiState
                )
            }
            WindowSizeClass.MEDIUM -> {
                MediumLayout(
                    navigator = navigator,
                    topBarType = topBarType,
                    jobExperienceUiState = jobExperienceUiState,
                    resumeItemUiState = resumeItemUiState,
                    contactUiState = contactUiState,
                    languageUiState = languageUiState,
                    skillUiState = skillUiState
                )
            }
            WindowSizeClass.EXPANDED -> {
                ExpandedLayout(
                    navigator = navigator,
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