package org.amp.project.domain

import org.amp.project.model.ThemeItem

interface ThemeRepository {
    fun getTheme(): ThemeItem
    fun setTheme(themeItem: ThemeItem): ThemeItem
}