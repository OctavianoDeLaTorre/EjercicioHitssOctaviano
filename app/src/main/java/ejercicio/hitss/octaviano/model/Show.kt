package ejercicio.hitss.octaviano.model

import ejercicio.hitss.octaviano.model.common.*
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

@Serializable
data class Show (
    val id: Long,
    val url: String,
    val name: String,
    val type: String,
    val language: String? = null,
    val genres: List<String>,
    val status: Status,
    val runtime: Long? = null,
    val averageRuntime: Long,
    val premiered: String,
    val ended: String? = null,
    val officialSite: String? = null,
    val schedule: Schedule,
    val rating: Rating,
    val weight: Long,
    val network: Network? = null,
    val webChannel: Network? = null,
    val dvdCountry: JsonObject? = null,
    val externals: Externals,
    val image: Image = Image(),
    val summary: String,
    val updated: Long,

    @SerialName("_links")
    val links: ShowLinks
)