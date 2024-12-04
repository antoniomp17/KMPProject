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
            endDate= "2024-10-01",
            image = "https://www.bancamediolanum.it/static-assets/images/elementi/2023/05/25/social-mediolanum-card.jpg",
            description =
                    "En este puesto, participé en el desarrollo y mantenimiento de las dos aplicaciones móviles principales de **Banco Mediolanum**, dirigidas tanto a los clientes como a los asesores financieros. Mi trabajo se centró en garantizar la calidad, estabilidad y rendimiento de las aplicaciones, así como en implementar nuevas funcionalidades para mejorar la experiencia del usuario.\n" +
                    "\n" +
                    "Entre mis responsabilidades clave se encuentran:\n" +
                    "\n" +
                    "- **Desarrollo de nuevas funcionalidades:** Diseñé e implementé mejoras evolutivas en las aplicaciones, introduciendo características innovadoras que optimizaron la experiencia del usuario y cubrieron nuevas necesidades del negocio.\n" +
                    "- **Optimización del rendimiento:** Realicé mejoras significativas en los tiempos de carga y en el consumo de memoria, lo que resultó en aplicaciones más rápidas y eficientes.\n" +
                    "- **Gestión de problemas:** Detecté y corregí bugs reportados por usuarios y equipos internos, asegurando versiones estables y confiables en cada lanzamiento.\n" +
                    "- **Documentación técnica:** Creé y gestioné documentación detallada en **Confluence**, facilitando la colaboración entre equipos y asegurando la trazabilidad de los desarrollos.\n" +
                    "- **Análisis de requerimientos:** Traducí los requerimientos funcionales en especificaciones técnicas claras y viables, alineando las necesidades del cliente con soluciones técnicas robustas.\n" +
                    "- **Gestión de tickets:** Utilicé **Jira** para la gestión de tickets y el manejo de incidentes críticos en producción, garantizando la continuidad del servicio.\n" +
                    "- **Colaboración con QA:** Trabajé estrechamente con los equipos de testing en pruebas de regresión y control de calidad, asegurando que cada nueva versión cumpliera con los estándares establecidos.\n" +
                    "\n" +
                    "Este puesto no solo me permitió mejorar mis habilidades técnicas, sino también colaborar en un entorno dinámico, priorizando la calidad del software y la satisfacción del cliente."
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
            description = ""
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
            image = "https://img.freepik.com/foto-gratis/asunto-comunicacion-conversacion-conversacion-juntos_1418-82.jpg?t=st=1732731376~exp=1732734976~hmac=d0df752129d98cbbec84412e2cd3bd4cd1275fffd6bfaffc0a7c358dd7c36168&w=1380",
            description = ""
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
            description = ""
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
            description = ""
        )
    )
}