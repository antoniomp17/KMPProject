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
            link = "https://play.google.com/store/apps/details?id=com.ja.driveguard",
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
            link = "https://www.uc3m.es/grado/telematica",
            type = ResumeItemType.EDUCATION
        ),
        ResumeItem(
            id = currentId++,
            itemName = "Kotlin Multiplatform Course",
            itemImageUrl = "https://webautomation.io/static/images/domain_images/Udemy-Emblem_cWmEXOG.png",
            siteName = "Udemy",
            siteImageUrl = "",
            location = "",
            startDate = "2024",
            endDate= "2024",
            link = "https://www.udemy.com/certificate/UC-09eec4f6-8156-4823-9754-9bd1c35b3c62/",
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
            link = "https://www.udemy.com/certificate/UC-dc6aaa2f-8b5e-4d03-b2cb-dfc64f063dac/",
            type = ResumeItemType.CERTIFICATE
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
            link = "https://www.udemy.com/certificate/UC-a814d1aa-99e2-4425-9778-ddc09199a241/",
            type = ResumeItemType.CERTIFICATE
        )
    )
}