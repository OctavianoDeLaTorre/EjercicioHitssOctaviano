package ejercicio.hitss.octaviano.model

import ejercicio.hitss.octaviano.model.common.*
import kotlinx.serialization.*

@Serializable
data class ScheduleElement(
    val id: Long,
    val url: String,
    val name: String,
    val season: Long,
    val number: Long? = null,
    val type: String? = null,
    val airdate: String,
    val airtime: String,
    val airstamp: String,
    val runtime: Long,
    val rating: Rating,
    val image: Image = Image(),
    val summary: String? = null,
    val show: Show,

    @SerialName("_links")
    val links: ScheduleLinks
)






















