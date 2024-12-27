package org.amp.project.di

import org.amp.project.data.contact.ContactManager
import org.amp.project.data.contact.ContactRepositoryImpl
import org.amp.project.domain.ContactRepository
import org.amp.project.presentation.ContactViewModel
import org.koin.dsl.module

fun contactItemModule() = module {

    single { ContactManager }
    single<ContactRepository> { ContactRepositoryImpl(get()) }
    factory { ContactViewModel(get()) }

}