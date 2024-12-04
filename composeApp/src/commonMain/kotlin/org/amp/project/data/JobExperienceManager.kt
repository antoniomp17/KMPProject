package org.amp.project.data

import org.amp.project.model.JobExperience

object JobExperienceManager {

    private var currentId = 1L

    val fakeJobExperienceList = mutableListOf(
        JobExperience(
            id = currentId++,
            position = "Android Developer",
            companyName = "Akkodis",
            companyImageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d5/Akkodis_logo.svg/1920px-Akkodis_logo.svg.png?20240102222423",
            clientName = "Mediolanum",
            clientImageUrl = "https://blog.bancomediolanum.es/wp-content/uploads/2016/09/mediolanum_banking_group.png",
            location = "Remote",
            startDate = "2023-07-01",
            endDate = "2024-10-01",
            image = "https://www.bancamediolanum.it/static-assets/images/elementi/2023/05/25/social-mediolanum-card.jpg",
            description =
            "As an **Android Developer** for **Akkodis**, I worked on the development and maintenance of the primary mobile applications for **Banco Mediolanum**, catering to both clients and financial advisors. The focus was on ensuring quality, stability, and performance, while introducing new features to enhance user experience.\n" +
                    "\n" +
                    "Key responsibilities and achievements included:\n" +
                    "\n" +
                    "- **Development of New Features:** Designed and implemented evolutionary improvements, adding innovative features to optimize user experience and address new business needs.\n" +
                    "- **Performance Optimization:** Significantly improved loading times and memory consumption, resulting in faster and more efficient applications.\n" +
                    "- **Bug Management:** Diagnosed and resolved issues reported by users and internal teams, ensuring stable and reliable releases.\n" +
                    "- **Technical Documentation:** Created and managed detailed documentation in **Confluence**, fostering collaboration and development traceability.\n" +
                    "- **Requirement Analysis:** Translated functional requirements into clear, feasible technical specifications.\n" +
                    "- **Ticket Management:** Used **Jira** for issue tracking and managing critical production incidents, ensuring uninterrupted service.\n" +
                    "- **QA Collaboration:** Worked closely with QA teams on regression testing and quality assurance to meet software standards for every release.\n" +
                    "\n" +
                    "This role strengthened my technical skills and enabled collaboration in a dynamic environment, prioritizing software quality and client satisfaction. \n" +
                    "\n" +
                    "You can explore the **Banco Mediolanum app** on the [Google Play Store here](https://play.google.com/store/apps/details?id=com.mediolanum)."
        ),
        JobExperience(
            id = currentId++,
            position = "Android Developer",
            companyName = "Panel Sistemas",
            companyImageUrl = "https://www.panel.es/wp-content/uploads/2021/03/Logo-panel_blanco.png",
            clientName = "Telefónica",
            clientImageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/7/79/Telef%C3%B3nica_2021_logo.svg/1920px-Telef%C3%B3nica_2021_logo.svg.png?20211009193120",
            location = "Remote",
            startDate = "2023-06-30",
            endDate= "2024-02-01",
            image = "https://www.adslzone.net/app/uploads-adslzone.net/2022/12/spotmusic-movistar.jpg",
            description =
            "As an **Android Developer** for Telefónica through **Panel Sistemas**, I played a key role in migrating a specialized embedded application, **SpotMusic**, used as a music player for businesses worldwide. The project focused on updating the application from **Android 5** to **Android 11**, ensuring compatibility and optimal performance on embedded devices.\n" +
                    "\n" +
                    "Key responsibilities and achievements included:\n" +
                    "\n" +
                    "- **Migration Planning:** Designed the modernization process, defining strategies for updating and adapting the application to the new operating system.\n" +
                    "- **Compatibility Updates:** Ensured seamless functionality with the new Android versions, overcoming challenges unique to embedded Android environments.\n" +
                    "- **Performance Optimization:** Optimized the application for performance, adapting it to the constraints of specialized hardware.\n" +
                    "- **End-to-End Implementation:** Executed the migration process, from initial planning to final deployment, ensuring minimal disruption to existing operations.\n" +
                    "\n" +
                    "This experience enriched my skills in handling embedded systems and adapting applications for long-term compatibility and improved performance. \n" +
                    "\n" +
                    "You can learn more about the **SpotMusic app** [here](https://www.telefonicaempresas.es/soluciones-digitales/spotmusic)."
        ),
        JobExperience(
            id = currentId++,
            position = "Android Developer",
            companyName = "Cloud On Mobile",
            companyImageUrl = "https://www.cloudonmobile.com/wp-content/uploads/2015/05/logo_com_2_white.png",
            clientName = "Grupo SM",
            clientImageUrl = "https://www.grupo-sm.com/sites/all/themes/sm_main_site_th/logo.png",
            location = "Remote",
            startDate = "2022-09-01",
            endDate= "2024-02-01",
            image = "https://www.grupo-sm.com/es/wp-content/uploads/2024/02/SM-educamos-atributo3.webp",
            description =
            "As an **Android Developer** at Cloud On Mobile, collaborating with Grupo SM, I contributed to the development and maintenance of mobile applications designed for the educational sector, catering to thousands of users. My role focused on delivering high-quality features and resolving issues to enhance the application's functionality and user experience.\n" +
                    "\n" +
                    "Key responsibilities and achievements included:\n" +
                    "\n" +
                    "- **Feature Development:** Actively participated in the implementation of new features, aligning with the client’s evolving needs in the education sector and ensuring the application remained competitive and user-friendly.\n" +
                    "- **Agile Collaboration:** Worked within agile teams, contributing to **biweekly releases** of new application versions. This required efficient sprint planning, daily stand-ups, and close collaboration with cross-functional teams.\n" +
                    "- **Bug Resolution:** Identified and resolved bugs in the application, ensuring a smooth user experience and minimizing downtime for users.\n" +
                    "- **Functionality Enhancements:** Implemented improvements to existing features, optimizing their performance and usability. This included refining workflows and addressing user feedback to meet high-quality standards.\n" +
                    "- **Continuous Optimization:** Focused on iterative development practices, ensuring the application maintained excellent performance as it evolved with new requirements.\n" +
                    "\n" +
                    "This role allowed me to deepen my expertise in agile development environments and mobile application optimization for large user bases. Working with Grupo SM provided valuable insights into creating impactful solutions for the educational industry while maintaining a strong commitment to quality and timely delivery."
        ),
        JobExperience(
            id = currentId++,
            position = "Android Developer",
            companyName = "Arquimea",
            companyImageUrl = "https://www.fpct.ulpgc.es/images/empresas/ARQUIMEA/ARQUIMEA_LOGO_POSITIVO.png",
            clientName = "",
            clientImageUrl = "",
            location = "Remote",
            startDate = "2021-03-01",
            endDate= "2022-08-31",
            image = "https://www.arquimea.com/wp-content/uploads/2022/06/arquimea_loitering-qslam40_web4-2048x1366.jpg",
            description =
            "As an **Android Developer** at Arquimea, I led the complete development of a mobile application tailored for the defense sector. Starting from scratch, I utilized modern architectures and cutting-edge technologies from 2021 to deliver a robust, high-performing, and scalable application for a demanding environment.\n" +
                    "\n" +
                    "Key responsibilities and achievements included:\n" +
                    "\n" +
                    "- **Architecture Design and Management:** Designed the application’s architecture to ensure scalability, maintainability, and optimal performance. This included selecting the best practices and patterns for a highly demanding environment.\n" +
                    "- **Custom Library Development:** Implemented specialized libraries to meet the application’s unique requirements, enabling seamless integration with external hardware and systems.\n" +
                    "- **Device Integration:** Developed robust solutions for connecting the application with external devices, ensuring smooth data reception and processing in **JSON format**.\n" +
                    "- **Modern Technologies:** Leveraged contemporary Android technologies to build a reliable and future-proof solution, meeting the specific needs of the defense sector.\n" +
                    "- **End-to-End Development:** Managed the entire development lifecycle, from ideation and design to testing and deployment, ensuring the final product adhered to strict performance and security standards.\n" +
                    "\n" +
                    "This experience was instrumental in strengthening my skills in full-cycle application development, particularly in the context of specialized and high-demand use cases. It provided invaluable exposure to working with custom architectures and device integrations while maintaining the highest standards of performance and reliability."
        ),
        JobExperience(
            id = currentId++,
            position = "Android Developer",
            companyName = "IMDEA Networks",
            companyImageUrl = "https://networks.imdea.org/wp-content/themes/in/img/logo/logo-imdea-networks.png",
            clientName = "",
            clientImageUrl = "",
            location = "Remote",
            startDate = "2018-08-01",
            endDate= "2019-07-31",
            image = "https://static.esmartcity.es/media/2019/11/presentan-innovador-sistema-basado-5g-situaciones-emergencias-sanitarias-1.png",
            description =
            "As an **Engineer Trainee** at IMDEA Networks, I participated in the development of a groundbreaking mobile application targeting the healthcare sector, as part of research into **5G networks** and wearable technology. This project was conducted in collaboration with **SAMUR Protección Civil**, focusing on enhancing emergency response systems for patients in critical conditions, such as cardiac arrest.\n" +
                    "\n" +
                    "Key responsibilities and achievements included:\n" +
                    "\n" +
                    "- **Application Development:** Designed and implemented a mobile application capable of processing and analyzing data collected by wearable devices, providing crucial insights to healthcare professionals.\n" +
                    "- **API Integration:** Integrated the application with external APIs, enabling the system to deliver real-time alerts and additional functionalities. This ensured seamless interaction with external services and emergency response frameworks.\n" +
                    "- **5G Network Research:** Supported research on **5G network technologies**, focusing on low-latency and reliable communication to enable faster response times in critical situations.\n" +
                    "- **Collaboration with SAMUR:** Contributed to a project aimed at developing a **5G-enabled wearable device** for **automatic notification of cardiac arrest patients** to emergency services. This collaboration demonstrated how technology can improve survival rates in medical emergencies.\n" +
                    "- **Healthcare Innovation:** Explored innovative solutions that combined mobile technology, wearables, and advanced network capabilities to revolutionize patient care and emergency response.\n" +
                    "\n" +
                    "This role provided me with invaluable experience in cutting-edge healthcare technology and its integration with next-generation networks. The collaboration with SAMUR and the insights gained from real-world applications of 5G technology significantly enriched my understanding of the impact of technology in life-saving scenarios.\n" +
                    "\n" +
                    "For more details about the project, you can read the official article [here](https://diario.madrid.es/blog/notas-de-prensa/samur-proteccion-civil-colabora-en-el-desarrollo-de-un-dispositivo-5g-de-aviso-automatico-de-pacientes-en-parada-cardiorrespiratoria/)."

        )
    )
}