package org.amp.project.data.theme

import org.amp.project.model.ThemeItem

object ThemeManager {

    var fakeTheme = ThemeItem(isDarkTheme = true)

    fun setTheme(themeItem: ThemeItem): ThemeItem {
        val newTheme = this.fakeTheme.copy(isDarkTheme = themeItem.isDarkTheme)
        return newTheme
    }

}