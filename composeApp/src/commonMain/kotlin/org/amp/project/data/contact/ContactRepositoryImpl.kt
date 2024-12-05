package org.amp.project.data.contact

import org.amp.project.domain.ContactRepository
import org.amp.project.model.ContactItem

class ContactRepositoryImpl(private var contactManager: ContactManager): ContactRepository {
    override fun getAllContacts(): List<ContactItem> {
        return contactManager.fakeJobExperienceList
    }
}