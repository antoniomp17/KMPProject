package org.amp.project.data.language

import org.amp.project.model.LanguageItem
import org.amp.project.model.LanguageLevel

object LanguageManager {
    private var currentId = 1L

    val fakeJobExperienceList = mutableListOf(
        LanguageItem(
            id = currentId++,
            language = "Spanish",
            level = LanguageLevel.NATIVE
        ),
        LanguageItem(
            id = currentId++,
            language = "English",
            level = LanguageLevel.PROFESSIONAL
        )
    )
}