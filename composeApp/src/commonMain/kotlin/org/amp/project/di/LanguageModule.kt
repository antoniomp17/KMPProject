package org.amp.project.di

import org.amp.project.data.language.LanguageManager
import org.amp.project.data.language.LanguageRepositoryImpl
import org.amp.project.domain.LanguageRepository
import org.amp.project.presentation.LanguageViewModel
import org.koin.dsl.module

fun languageItemModule() = module {

    single { LanguageManager }
    single<LanguageRepository> { LanguageRepositoryImpl(get()) }
    factory { LanguageViewModel(get()) }

}