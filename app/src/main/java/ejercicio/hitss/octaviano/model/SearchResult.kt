package ejercicio.hitss.octaviano.model

import kotlinx.serialization.*

@Serializable
data class SearchResult(
    val score: Double,
    val show: Show
)