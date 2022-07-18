package ejercicio.hitss.octaviano.model.common

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder


@Serializable
enum class Gender(val value: String) {
    Female("Female"),
    Male("Male");

    companion object : KSerializer<Gender> {
        override val descriptor: SerialDescriptor
            get() {
            return PrimitiveSerialDescriptor("Gender", PrimitiveKind.STRING)
        }
        override fun deserialize(decoder: Decoder): Gender = when (val value = decoder.decodeString()) {
            "Female" -> Female
            "Male"   -> Male
            else     -> throw IllegalArgumentException("Gender could not parse: $value")
        }
        override fun serialize(encoder: Encoder, value: Gender) {
            return encoder.encodeString(value.value)
        }
    }
}
