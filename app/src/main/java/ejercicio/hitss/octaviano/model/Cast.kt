package ejercicio.hitss.octaviano.model

import kotlinx.serialization.*

@Serializable
data class Cast(
    val person: Person,
    val character: ejercicio.hitss.octaviano.model.common.Character,
    val self: Boolean,
    val voice: Boolean
)

