package org.amp.project.model

import androidx.compose.ui.graphics.vector.ImageVector

data class LanguageItem(
    val id: Long = -1,
    val language: String,
    val flag: ImageVector,
    val level: LanguageLevel
)

enum class LanguageLevel(val description: String){
    ELEMENTARY("Elementary proficiency"),
    LIMITED("Limited working proficiency"),
    PROFESSIONAL("Professional working proficiency"),
    FULL("Full professional proficiency"),
    NATIVE("Native")
}