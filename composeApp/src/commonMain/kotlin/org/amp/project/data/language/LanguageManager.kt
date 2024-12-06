package org.amp.project.data.language

import org.amp.project.model.LanguageItem
import org.amp.project.model.LanguageLevel

object LanguageManager {
    private var currentId = 1L

    val fakeJobExperienceList = mutableListOf(
        LanguageItem(
            id = currentId++,
            language = "Spanish",
            flag = "\uD83C\uDDEA\uD83C\uDDF8",
            level = LanguageLevel.NATIVE
        ),
        LanguageItem(
            id = currentId++,
            language = "English",
            flag = "\uD83C\uDDEC\uD83C\uDDE7",
            level = LanguageLevel.PROFESSIONAL
        )
    )
}