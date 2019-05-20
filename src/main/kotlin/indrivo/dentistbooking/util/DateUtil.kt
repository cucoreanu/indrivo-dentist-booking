package indrivo.dentistbooking.util

import java.util.*

class DateUtil {
    companion object {
        fun addMillisecondsToDate(date: Date, milliseconds: Int): Date {
            val calendar = Calendar.getInstance()
            calendar.timeInMillis = date.time
            calendar.add(Calendar.MILLISECOND, milliseconds)
            return calendar.time
        }
    }
}
