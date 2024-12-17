package org.amp.project.data.theme

import org.amp.project.domain.ThemeRepository
import org.amp.project.model.ThemeItem

class ThemeRepositoryImpl(private val themeManager: ThemeManager): ThemeRepository {
    override fun getTheme(): ThemeItem {
        return themeManager.fakeTheme
    }

    override fun setTheme(themeItem: ThemeItem): ThemeItem {
        return themeManager.setTheme(themeItem = themeItem)
    }

}