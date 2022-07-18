package ejercicio.hitss.octaviano.model.common

import kotlinx.serialization.Serializable

@Serializable
data class Country (
    val name: String,
    val code: String,
    val timezone: String
)