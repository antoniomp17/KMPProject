package org.amp.project.data.resumeItem

import org.amp.project.domain.ResumeItemRepository
import org.amp.project.model.ResumeItem

class ResumeItemRepositoryImpl(private var resumeItemManager: ResumeItemManager) : ResumeItemRepository {
    override fun getAllResumeItems(): List<ResumeItem> {
        return resumeItemManager.fakeResumeItemList
    }
}