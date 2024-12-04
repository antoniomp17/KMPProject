package org.amp.project.model

data class ResumeItem(
    val id: Long = -1,
    val itemName: String,
    val itemImageUrl: String,
    val siteName: String,
    val siteImageUrl: String,
    val location: String,
    val startDate: String,
    val endDate: String,
    val link: String,
    val type: ResumeItemType
)

enum class ResumeItemType(val title: String){
    PROJECT("Projects"),
    EDUCATION("Education"),
    CERTIFICATE("Certificates")
}
