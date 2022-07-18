package ejercicio.hitss.octaviano.model.common

import kotlinx.serialization.Serializable

@Serializable
data class Image (
    val medium: String = "",
    val original: String = ""
)