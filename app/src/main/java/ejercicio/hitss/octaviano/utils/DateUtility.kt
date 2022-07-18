package ejercicio.hitss.octaviano.utils

import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.*

object DateUtility {

    /**
     * Regresa la fecha actual con el nombre del mes y día.
     *
     * @return Fecha actual en formato String
     */
    fun getCurrentDate(): String {

        val locale = Locale("es", "ES")

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O){
            val currentDate = LocalDate.now()
            val month = currentDate.month.getDisplayName(TextStyle.FULL, locale)
            val year = currentDate.year
            val day = currentDate.dayOfWeek
            val dayName: String = day.getDisplayName(TextStyle.FULL, locale)

            return "$dayName ${day.value} de $month $year".replaceFirstChar { it.uppercase() }
        } else{
            val date = Calendar.getInstance().time

            val dayName = SimpleDateFormat("EEEE", locale).format(date.time)
            val month = SimpleDateFormat("LLLL", locale).format(date.time)

            return "$dayName ${date.day} de $month ${date.year}".replaceFirstChar { it.uppercase() }
        }



    }


    /**
     * Regresa la fecha actual con el formato ISO 8601 (yyyy-mm-dd).
     *
     * @return Fecha actual en formato String
     */
    fun getDate(): String = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())

}
