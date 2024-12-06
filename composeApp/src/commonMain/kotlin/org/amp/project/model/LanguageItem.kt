package org.amp.project.model

data class LanguageItem(
    val id: Long = -1,
    val language: String,
    val level: LanguageLevel
)

enum class LanguageLevel(val description: String){
    ELEMENTARY("Elementary proficiency"),
    LIMITED("Limited working proficiency"),
    PROFESSIONAL("Professional working proficiency"),
    FULL("Full professional proficiency"),
    NATIVE("Native or Bilingual proficiency")
}