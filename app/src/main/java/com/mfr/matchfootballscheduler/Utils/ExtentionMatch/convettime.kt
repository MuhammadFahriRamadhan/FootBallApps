package com.mfr.matchfootballscheduler.Utils.ExtentionMatch

import java.text.SimpleDateFormat
import java.util.*

internal fun convertime(time : String): String {

    val formatter = SimpleDateFormat("HH:mm", Locale.getDefault())
    formatter.timeZone = TimeZone.getTimeZone("UTC")
    val times = formatter.parse(time)

    val formatters = SimpleDateFormat("HH:mm", Locale.getDefault())
    val timess = formatters.format(times)


return timess.toString()
}