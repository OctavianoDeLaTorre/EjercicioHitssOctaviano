package ejercicio.hitss.octaviano.model.common

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@Serializable
enum class Day(val value: String) {
    Friday("Friday"),
    Monday("Monday"),
    Saturday("Saturday"),
    Sunday("Sunday"),
    Thursday("Thursday"),
    Tuesday("Tuesday"),
    Wednesday("Wednesday");

    override fun toString(): String {
        return this.value
    }

    companion object : KSerializer<Day> {
        override val descriptor: SerialDescriptor
            get() {
                return PrimitiveSerialDescriptor("quicktype.Day", PrimitiveKind.STRING)
            }

        override fun deserialize(decoder: Decoder): Day =
            when (val value = decoder.decodeString()) {
                "Friday" -> Friday
                "Monday" -> Monday
                "Saturday" -> Saturday
                "Sunday" -> Sunday
                "Thursday" -> Thursday
                "Tuesday" -> Tuesday
                "Wednesday" -> Wednesday
                else -> throw IllegalArgumentException("Day could not parse: $value")
            }

        override fun serialize(encoder: Encoder, value: Day) {
            return encoder.encodeString(value.value)
        }
    }
}