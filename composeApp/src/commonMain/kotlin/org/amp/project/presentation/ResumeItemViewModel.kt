package org.amp.project.presentation

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import moe.tlaster.precompose.viewmodel.ViewModel
import moe.tlaster.precompose.viewmodel.viewModelScope
import org.amp.project.domain.ResumeItemRepository
import org.amp.project.model.ResumeItem
import org.amp.project.model.ResumeItemType

data class ResumeItemUiState(
    val allResumeItems: List<ResumeItem> = emptyList(),
    val projectResumeItems: List<ResumeItem> = emptyList(),
    val educationResumeItems: List<ResumeItem> = emptyList(),
    val certificateResumeItems: List<ResumeItem> = emptyList()
)

class ResumeItemViewModel(private val repo: ResumeItemRepository): ViewModel(){

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
                projectResumeItems = getResumeItemProject(),
                educationResumeItems = getResumeItemEducation(),
                certificateResumeItems = getResumeItemCertificate()
            )
        }
    }

    private fun getResumeItemProject(): List<ResumeItem> {
        return allResumeItems.filter { it.type == ResumeItemType.PROJECT }
    }

    private fun getResumeItemEducation(): List<ResumeItem> {
        return allResumeItems.filter { it.type == ResumeItemType.EDUCATION }
    }

    private fun getResumeItemCertificate(): List<ResumeItem> {
        return allResumeItems.filter { it.type == ResumeItemType.CERTIFICATE }
    }

    fun getResumeItemById(id: Long) = allResumeItems.first { it.id == id }

}