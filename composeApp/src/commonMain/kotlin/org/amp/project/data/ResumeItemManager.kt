package org.amp.project.data

import org.amp.project.model.ResumeItem
import org.amp.project.model.ResumeItemType

object ResumeItemManager {

    private var currentId = 1L

    val fakeResumeItemList = mutableListOf(
        ResumeItem(
            id = currentId++,
            itemName = "DriveGuard",
            itemImageUrl = "https://play-lh.googleusercontent.com/dT60biAUDS3iuxL6W8spwuuqp_VLY4VtRC6cwYv329aifgUxFkh-Gak_pHYDIeNDug=w240-h480-rw",
            siteName = "Play Store",
            siteImageUrl = "",
            location = "",
            startDate = "2023",
            endDate= "Current",
            description = "",
            type = ResumeItemType.PROJECT
        ),
        ResumeItem(
            id = currentId++,
            itemName = "Telematics Engineering",
            itemImageUrl = "https://static.docsity.com/media/avatar/universities/7339.png",
            siteName = "UC3M",
            siteImageUrl = "",
            location = "Madrid, Spain",
            startDate = "2016",
            endDate= "2022",
            description = "",
            type = ResumeItemType.EDUCATION
        ),
        ResumeItem(
            id = currentId++,
            itemName = "Jetpack Compose Course",
            itemImageUrl = "https://webautomation.io/static/images/domain_images/Udemy-Emblem_cWmEXOG.png",
            siteName = "Udemy",
            siteImageUrl = "",
            location = "",
            startDate = "2024",
            endDate= "2024",
            description = "",
            type = ResumeItemType.CERTIFICATE
        ),
        ResumeItem(
            id = currentId++,
            itemName = "Testing Course",
            itemImageUrl = "https://webautomation.io/static/images/domain_images/Udemy-Emblem_cWmEXOG.png",
            siteName = "Udemy",
            siteImageUrl = "",
            location = "",
            startDate = "2024",
            endDate= "2024",
            description = "",
            type = ResumeItemType.CERTIFICATE
        )
    )
}