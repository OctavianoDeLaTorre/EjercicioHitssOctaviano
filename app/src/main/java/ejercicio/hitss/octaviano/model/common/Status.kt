package ejercicio.hitss.octaviano.model.common

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@Serializable
enum class Status(val value: String) {
    Ended("Ended"),
    Running("Running");

    companion object : KSerializer<Status> {
        override val descriptor: SerialDescriptor
            get() {
            return PrimitiveSerialDescriptor("quicktype.Status", PrimitiveKind.STRING)
        }
        override fun deserialize(decoder: Decoder): Status = when (val value = decoder.decodeString()) {
            "Ended"   -> Ended
            "Running" -> Running
            else      -> Ended
        }
        override fun serialize(encoder: Encoder, value: Status) {
            return encoder.encodeString(value.value)
        }
    }
}