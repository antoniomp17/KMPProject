package org.amp.project.presentation

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import moe.tlaster.precompose.viewmodel.ViewModel
import moe.tlaster.precompose.viewmodel.viewModelScope
import org.amp.project.domain.ContactRepository
import org.amp.project.model.ContactItem

data class ContactUiState(
    val contacts: List<ContactItem> = emptyList()
)

class ContactViewModel(private val repo: ContactRepository): ViewModel(){

    private val _uiState = MutableStateFlow(ContactUiState())
    val uiState = _uiState.asStateFlow()
    private val allJobExperiences = repo.getAllContacts()

    init{
        getAllContacts()
    }

    private fun getAllContacts(){
        viewModelScope.launch {
            updateState()
        }
    }

    private fun updateState() {
        _uiState.update { state ->
            state.copy(contacts = allJobExperiences)
        }
    }

}