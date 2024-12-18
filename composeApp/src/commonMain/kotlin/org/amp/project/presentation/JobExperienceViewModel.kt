package org.amp.project.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.amp.project.domain.JobExperienceRepository
import org.amp.project.model.JobExperienceItem

data class JobExperienceUiState(
    val jobExperiences: List<JobExperienceItem> = emptyList()
){
    fun getJobExperienceById(id: Long): JobExperienceItem {
        return jobExperiences.first { it.id == id }
    }
}

class JobExperienceViewModel(repo: JobExperienceRepository): ViewModel(){

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

}