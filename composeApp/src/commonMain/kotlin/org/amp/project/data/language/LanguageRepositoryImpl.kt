package org.amp.project.data.language

import org.amp.project.domain.LanguageRepository
import org.amp.project.model.LanguageItem

class LanguageRepositoryImpl(private var languageManager: LanguageManager): LanguageRepository {
    override fun getAllLanguages(): List<LanguageItem> {
        return languageManager.fakeJobExperienceList
    }

}