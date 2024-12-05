package org.amp.project.presentation

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import moe.tlaster.precompose.viewmodel.ViewModel
import moe.tlaster.precompose.viewmodel.viewModelScope
import org.amp.project.domain.JobExperienceRepository
import org.amp.project.model.JobExperienceItem

data class JobExperienceUiState(
    val jobExperiences: List<JobExperienceItem> = emptyList()
)

class JobExperienceViewModel(private val repo: JobExperienceRepository): ViewModel(){

    private val _uiState = MutableStateFlow(JobExperienceUiState())
    val uiState = _uiState.asStateFlow()
    private val allJobExperiences = repo.getAllJobExperiences()

    init{
        getAllJobExperiences()
    }

    private fun getAllJobExperiences(){
        viewModelScope.launch {
            updateState()
        }
    }

    private fun updateState() {
        _uiState.update { state ->
            state.copy(jobExperiences = allJobExperiences)
        }
    }

    fun getJobExperienceById(id: Long): JobExperienceItem {
        return allJobExperiences.first { it.id == id }
    }

}