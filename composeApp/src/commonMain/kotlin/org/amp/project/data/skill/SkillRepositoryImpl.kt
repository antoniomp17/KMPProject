package org.amp.project.data.skill

import org.amp.project.domain.SkillRepository
import org.amp.project.model.SkillItem

class SkillRepositoryImpl(private var skillManager: SkillManager): SkillRepository {
    override fun getAllSkills(): List<SkillItem> {
        return skillManager.fakeSkillList
    }
}