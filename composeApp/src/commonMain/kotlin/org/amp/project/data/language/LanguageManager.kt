package org.amp.project.data.language

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Language
import org.amp.project.model.LanguageItem
import org.amp.project.model.LanguageLevel

object LanguageManager {
    private var currentId = 1L

    val fakeJobExperienceList = mutableListOf(
        LanguageItem(
            id = currentId++,
            language = "Spanish",
            flag = Icons.Default.Home,
            level = LanguageLevel.NATIVE
        ),
        LanguageItem(
            id = currentId++,
            language = "English",
            flag = Icons.Default.Language,
            level = LanguageLevel.PROFESSIONAL
        )
    )
}