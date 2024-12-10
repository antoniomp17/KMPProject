package org.amp.project.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.amp.project.domain.SkillRepository
import org.amp.project.model.SkillItem

data class SkillUiState(
    val skills: List<SkillItem> = emptyList()
)

class SkillViewModel(repo: SkillRepository): ViewModel(){

    private val _uiState = MutableStateFlow(SkillUiState())
    val uiState = _uiState.asStateFlow()
    private val allSkills = repo.getAllSkills()

    init{
        getAllSkills()
    }

    private fun getAllSkills(){
        viewModelScope.launch {
            updateState()
        }
    }

    private fun updateState() {
        _uiState.update { state ->
            state.copy(
                skills = allSkills
            )
        }
    }

}