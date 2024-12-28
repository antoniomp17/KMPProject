package org.amp.project.data.contact

import org.amp.project.model.ContactItem
import org.amp.project.model.ContactItemType

object ContactManager {

    private var currentId = 1L

    val fakeContactList = mutableListOf(
        ContactItem(
            id = currentId++,
            type = ContactItemType.MAIL,
            title = "Email",
            data = "antoniomoraleda17@gmail.com"
        ),
        ContactItem(
            id = currentId++,
            type = ContactItemType.PHONE,
            title = "Phone",
            data = "+34 667 868 919"
        ),
        ContactItem(
            id = currentId++,
            type = ContactItemType.LINKEDIN,
            title = "LinkedIn",
            url = "https://www.linkedin.com/in/amoraleda17/"
        )
    )
}