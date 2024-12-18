package org.amp.project.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.amp.project.domain.OtherResumeItemRepository
import org.amp.project.model.ResumeItem
import org.amp.project.model.ResumeItemType

data class ResumeItemUiState(
    val allResumeItems: List<ResumeItem> = emptyList(),
    val projectResumeItems: List<ResumeItem> = emptyList(),
    val educationResumeItems: List<ResumeItem> = emptyList(),
    val certificateResumeItems: List<ResumeItem> = emptyList()
)

class ResumeItemViewModel(repo: OtherResumeItemRepository): ViewModel(){

    private val _uiState = MutableStateFlow(ResumeItemUiState())
    val uiState = _uiState.asStateFlow()
    private val allResumeItems = repo.getAllResumeItems()

    init{
        getAllResumeItems()
    }

    private fun getAllResumeItems(){
        viewModelScope.launch {
            updateState()
        }
    }

    private fun updateState() {
        _uiState.update { state ->
            state.copy(
                allResumeItems = allResumeItems,
                projectResumeItems = getResumeItemsProject(),
                educationResumeItems = getResumeItemsEducation(),
                certificateResumeItems = getResumeItemsCertificate()
            )
        }
    }

    private fun getResumeItemsProject(): List<ResumeItem> {
        return allResumeItems.filter { it.type == ResumeItemType.PROJECT }
    }

    private fun getResumeItemsEducation(): List<ResumeItem> {
        return allResumeItems.filter { it.type == ResumeItemType.EDUCATION }
    }

    private fun getResumeItemsCertificate(): List<ResumeItem> {
        return allResumeItems.filter { it.type == ResumeItemType.CERTIFICATE }
    }

    fun getResumeItemById(id: Long) = allResumeItems.first { it.id == id }

}