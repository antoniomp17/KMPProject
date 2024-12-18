package org.amp.project.domain

import org.amp.project.model.LanguageItem

interface LanguageRepository {
    fun getAllLanguages(): List<LanguageItem>
}