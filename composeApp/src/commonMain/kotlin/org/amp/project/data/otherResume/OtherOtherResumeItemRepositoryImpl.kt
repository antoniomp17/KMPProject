package org.amp.project.data.otherResume

import org.amp.project.domain.OtherResumeItemRepository
import org.amp.project.model.ResumeItem

class OtherOtherResumeItemRepositoryImpl(private var resumeItemManager: OtherResumeItemManager) : OtherResumeItemRepository {
    override fun getAllResumeItems(): List<ResumeItem> {
        return resumeItemManager.fakeResumeItemList
    }
}