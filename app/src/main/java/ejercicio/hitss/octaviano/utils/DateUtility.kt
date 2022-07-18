package ejercicio.hitss.octaviano.utils

import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.*

object DateUtility {

    fun getCurrentDate(): String {
        val currentDate = LocalDate.now()
        val locale = Locale("es", "ES")

        val month = currentDate.month.getDisplayName(TextStyle.FULL, locale)
        val year = currentDate.year
        val day = currentDate.dayOfWeek

        val dayName: String = day.getDisplayName(TextStyle.FULL, locale)

        return "$dayName ${day.value} de $month $year".replaceFirstChar { it.uppercase() }
    }

    fun getDate(): String = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())

}
