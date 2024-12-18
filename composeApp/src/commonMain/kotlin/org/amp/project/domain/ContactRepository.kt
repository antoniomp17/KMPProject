package org.amp.project.domain

import org.amp.project.model.ContactItem

interface ContactRepository {
    fun getAllContacts(): List<ContactItem>
}