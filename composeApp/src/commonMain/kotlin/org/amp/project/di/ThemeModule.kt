package org.amp.project.di

import org.amp.project.data.theme.ThemeManager
import org.amp.project.data.theme.ThemeRepositoryImpl
import org.amp.project.domain.ThemeRepository
import org.amp.project.presentation.ThemeViewModel
import org.koin.dsl.module

fun themeItemModule() = module {

    single { ThemeManager }
    single<ThemeRepository> { ThemeRepositoryImpl(get()) }
    factory { ThemeViewModel(get()) }

}