package org.amp.project.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.amp.project.domain.LanguageRepository
import org.amp.project.model.LanguageItem

data class LanguageUiState(
    val languages: List<LanguageItem> = emptyList()
)

class LanguageViewModel(repo: LanguageRepository): ViewModel() {

    private val _uiState = MutableStateFlow(LanguageUiState())
    val uiState = _uiState.asStateFlow()
    private val allLanguages = repo.getAllLanguages()

    init{
        getAllLanguages()
    }

    private fun getAllLanguages(){
        viewModelScope.launch {
            updateState()
        }
    }

    private fun updateState() {
        _uiState.update { state ->
            state.copy(
                languages = allLanguages
            )
        }
    }

}