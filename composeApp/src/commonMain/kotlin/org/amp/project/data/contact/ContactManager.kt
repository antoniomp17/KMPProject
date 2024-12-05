package org.amp.project.data.contact

import org.amp.project.model.ContactItem
import org.amp.project.model.ContactItemType

object ContactManager {

    private var currentId = 1L

    val fakeJobExperienceList = mutableListOf(
        ContactItem(
            id = currentId++,
            type = ContactItemType.MAIL,
            data = "antoniomoraleda17@gmail.com"
        ),
        ContactItem(
            id = currentId++,
            type = ContactItemType.PHONE,
            data = "+34 667 868 919"
        ),
        ContactItem(
            id = currentId++,
            type = ContactItemType.LINKEDIN,
            data = "https://www.linkedin.com/in/amoraleda17/"
        )
    )
}