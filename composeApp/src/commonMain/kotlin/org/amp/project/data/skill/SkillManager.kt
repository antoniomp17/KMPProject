package org.amp.project.data.skill

import org.amp.project.model.SkillItem

object SkillManager {

    private var currentId = 1L

    val fakeSkillList = mutableListOf(
        SkillItem(
            id = currentId++,
            skill = "Kotlin",
            iconUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/3/37/Kotlin_Icon_2021.svg/1024px-Kotlin_Icon_2021.svg.png",
            experience = "4 years"
        ),
        SkillItem(
            id = currentId++,
            skill = "Java",
            iconUrl = "https://upload.wikimedia.org/wikipedia/en/thumb/3/30/Java_programming_language_logo.svg/800px-Java_programming_language_logo.svg.png",
            experience = "4 years"
        ),
        SkillItem(
            id = currentId++,
            skill = "Jetpack Compose",
            iconUrl = "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEjC97Z8BResg5dlPqczsRCFhP6zewWX0X0e7fVPG-G7PuUZwwZVsi9OPoqJYkgqT2h0FI95SsmWzVEgpt8b8HAqFiIxZ98TFtY4lE0b8UrtVJ2HrJebRwl6C9DslsQDl9KnBIrdHS6LtkY/s1600/jetpack+compose+icon_RGB.png",
            experience = "2 years"
        ),
        SkillItem(
            id = currentId++,
            skill = "KMP",
            iconUrl = "https://lp.jetbrains.com/static/2021/03/23/155113-0.15265793.png",
            experience = "1 year"
        ),
        SkillItem(
            id = currentId++,
            skill = "Android Jetpack",
            iconUrl = "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEgDO1eKkrXPdSBxo_ZNX250ZBNH-FfexvOxc3mDX8LfcCRCByx0OOWzAGDqYPauyn3BZQq7Kw0K3zC_Hkg1ioaMkBeobbINIlF-h2NLMhO5IgNMYGI5EUQ0acIwITbQb8WFI8vgfj2yYx8/s1600/Jetpack_logo+%25282%2529.png",
            experience = "4 years"
        ),
        SkillItem(
            id = currentId++,
            skill = "Clean Arch",
            iconUrl = "https://www.milanjovanovic.tech/blogs/mnw_004/clean_architecture.png",
            experience = "2 years"
        ),
        SkillItem(
            id = currentId++,
            skill = "MVVM",
            iconUrl = "https://raw.githubusercontent.com/irontec/android-mvvm-example/master/logo.png",
            experience = "3 years"
        ),
        SkillItem(
            id = currentId++,
            skill = "Room",
            iconUrl = "https://raw.githubusercontent.com/irontec/android-room-example/master/logo.png",
            experience = "3 years"
        ),
        SkillItem(
            id = currentId++,
            skill = "Retrofit",
            iconUrl = "https://promwad.com/sites/default/files/retrofit.png",
            experience = "3 years"
        ),
        SkillItem(
            id = currentId++,
            skill = "Hilt",
            iconUrl = "https://cdn-icons-png.flaticon.com/512/1453/1453621.png",
            experience = "2 years"
        ),
        SkillItem(
            id = currentId++,
            skill = "Coroutines",
            iconUrl = "https://static-00.iconduck.com/assets.00/random-icon-2048x1319-ex4hb7ld.png",
            experience = "2 years"
        ),
        SkillItem(
            id = currentId++,
            skill = "Git",
            iconUrl = "https://git-scm.com/images/logos/downloads/Git-Icon-1788C.png",
            experience = "4 years"
        ),
        SkillItem(
            id = currentId++,
            skill = "SOLID",
            iconUrl = "https://miro.medium.com/v2/resize:fit:1191/1*yQNtz6czdgE1MhUbffmqKw.png",
            experience = "3 years"
        ),
        SkillItem(
            id = currentId++,
            skill = "SQLite",
            iconUrl = "https://dwglogo.com/wp-content/uploads/2018/03/SQLite_Vector_logo.png",
            experience = "3 years"
        ),
        SkillItem(
            id = currentId++,
            skill = "Firebase",
            iconUrl = "https://cdn4.iconfinder.com/data/icons/google-i-o-2016/512/google_firebase-2-512.png",
            experience = "2 years"
        ),
        SkillItem(
            id = currentId++,
            skill = "Glide",
            iconUrl = "https://user-images.githubusercontent.com/24237865/95545537-1bc15200-0a39-11eb-883d-644f564da5d3.png",
            experience = "2 years"
        ),
        SkillItem(
            id = currentId++,
            skill = "Coil",
            iconUrl = "https://avatars.githubusercontent.com/u/52722434?s=200&v=4",
            experience = "2 years"
        ),
        SkillItem(
            id = currentId++,
            skill = "Gradle",
            iconUrl = "https://avatars.githubusercontent.com/u/124156?s=200&v=4",
            experience = "3 years"
        ),
        SkillItem(
            id = currentId++,
            skill = "Proguard",
            iconUrl = "https://cdn-icons-png.flaticon.com/512/9414/9414678.png",
            experience = "1 year"
        ),
        SkillItem(
            id = currentId++,
            skill = "Google Play Console",
            iconUrl = "https://play-lh.googleusercontent.com/4_RW0mQ5mJhGGJVydTlQsQ0pnqAYq9UoTVm2_gElrgRM13Q02w43HPgYVaMFy4b4smmF",
            experience = "2 years"
        ),
        SkillItem(
            id = currentId++,
            skill = "JUnit",
            iconUrl = "https://svgicons.com/api/ogimage/?id=26052&n=junit",
            experience = "2 years"
        ),
        SkillItem(
            id = currentId++,
            skill = "Robolectric",
            iconUrl = "https://summerofcode.withgoogle.com/media/org/robolectric/lazlu9me0dgu60vq-360.png",
            experience = "1 year"
        ),
        SkillItem(
            id = currentId++,
            skill = "Espresso",
            iconUrl = "https://developer.android.com/static/images/training/testing/espresso.png",
            experience = "2 years"
        ),
        SkillItem(
            id = currentId++,
            skill = "Jenkins",
            iconUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e9/Jenkins_logo.svg/1483px-Jenkins_logo.svg.png",
            experience = "1 year"
        )
    )
}