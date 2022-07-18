package ejercicio.hitss.octaviano.model.common

import kotlinx.serialization.Serializable

@Serializable
data class ShowLinks (
    val self: Self,
    val previousepisode: Self,
    val nextepisode: Self? = null
)