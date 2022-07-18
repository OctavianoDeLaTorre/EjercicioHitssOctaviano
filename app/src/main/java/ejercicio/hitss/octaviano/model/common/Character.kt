package ejercicio.hitss.octaviano.model.common

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Character (
    val id: Long,
    val url: String,
    val name: String,
    val image: Image = Image(),

    @SerialName("_links")
    val links: Links
)