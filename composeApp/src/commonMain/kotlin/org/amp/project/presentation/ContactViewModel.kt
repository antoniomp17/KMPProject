package org.amp.project.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.amp.project.domain.ContactRepository
import org.amp.project.model.ContactItem
import org.amp.project.model.ContactItemType

data class ContactUiState(
    val phoneMails: List<ContactItem> = emptyList(),
    val socials: List<ContactItem> = emptyList()
)

class ContactViewModel(repo: ContactRepository): ViewModel(){

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
            state.copy(
                phoneMails = getPhoneEmail(),
                socials = getSocial()
            )
        }
    }

    private fun getPhoneEmail(): List<ContactItem> {
        return allJobExperiences.filter { it.type == ContactItemType.PHONE ||
                it.type == ContactItemType.MAIL }
    }

    private fun getSocial(): List<ContactItem> {
        return allJobExperiences.filter { it.type != ContactItemType.PHONE &&
                it.type != ContactItemType.MAIL }
    }

}