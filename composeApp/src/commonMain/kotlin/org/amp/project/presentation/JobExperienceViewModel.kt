package org.amp.project.presentation

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import moe.tlaster.precompose.viewmodel.ViewModel
import org.amp.project.domain.JobExperienceRepository
import org.amp.project.model.JobExperience

data class JobExperienceUiState(
    val jobExperiences: List<JobExperience> = emptyList()
)

class JobExperienceViewModel(private val repo: JobExperienceRepository): ViewModel(){

    private val _uiState = MutableStateFlow(JobExperienceUiState())
    val uiState = _uiState.asStateFlow()

}