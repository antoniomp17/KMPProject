package org.amp.project.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.amp.project.domain.ThemeRepository
import org.amp.project.model.ThemeItem

data class ThemeUiState(
    val theme: ThemeItem? = null
)

class ThemeViewModel(private val repo: ThemeRepository): ViewModel(){

    private val _uiState = MutableStateFlow(ThemeUiState())
    val uiState = _uiState.asStateFlow()

    init{
        updateState(theme = repo.getTheme())
    }

    private fun updateState(theme: ThemeItem? = null) {
        _uiState.update { state ->
            state.copy(
                theme = theme
            )
        }
    }

    fun changeTheme(isDarkTheme: Boolean){
        viewModelScope.launch {
            updateState(theme = repo.setTheme(ThemeItem(isDarkTheme)))
        }
    }

}