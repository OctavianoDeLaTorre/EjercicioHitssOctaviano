package ejercicio.hitss.octaviano.model.common

import kotlinx.serialization.Serializable

@Serializable
data class Network (
    val id: Long,
    val name: String,
    val country: Country,
    val officialSite: String? = null
)