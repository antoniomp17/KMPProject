package org.amp.project.presentation

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import moe.tlaster.precompose.viewmodel.ViewModel
import moe.tlaster.precompose.viewmodel.viewModelScope
import org.amp.project.domain.SkillRepository
import org.amp.project.model.SkillItem

data class SkillUiState(
    val skills: List<SkillItem> = emptyList()
)

class SkillViewModel(private val repo: SkillRepository): ViewModel(){

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