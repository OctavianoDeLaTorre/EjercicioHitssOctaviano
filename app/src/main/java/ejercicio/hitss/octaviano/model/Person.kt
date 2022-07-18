package ejercicio.hitss.octaviano.model

import ejercicio.hitss.octaviano.model.common.Country
import ejercicio.hitss.octaviano.model.common.Gender
import ejercicio.hitss.octaviano.model.common.Image
import ejercicio.hitss.octaviano.model.common.Links
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Person(
    val id: Long,
    val url: String? = null,
    val name: String,
    val country: Country? = null,
    val birthday: String? = null,
    val gender: Gender? = null,
    val image: Image = Image(),
    val updated: Long? = null,

    @SerialName("_links")
    val links: Links? = null
)