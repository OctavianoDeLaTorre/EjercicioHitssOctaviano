package ejercicio.hitss.octaviano.model.common

import kotlinx.serialization.Serializable

@Serializable
data class Schedule (
    val time: String,
    val days: List<Day>
)