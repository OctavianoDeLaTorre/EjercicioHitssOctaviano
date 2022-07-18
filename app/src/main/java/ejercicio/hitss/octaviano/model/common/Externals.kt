package ejercicio.hitss.octaviano.model.common

import kotlinx.serialization.Serializable

@Serializable
data class Externals (
    val tvrage: Long? = null,
    val thetvdb: Long? = null,
    val imdb: String? = null
)