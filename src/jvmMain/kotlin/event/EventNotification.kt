package event

import core.CalendarNotification
import core.Notification
import java.time.Instant
import java.time.LocalTime
import java.time.ZoneId
import java.time.temporal.ChronoUnit

/**
 * Notification for in-game event.
 *
 * @constructor
 * @property remindBeforeInMinutes Offset to every schedule time (in minutes).
 */
abstract class EventNotification(
    private val remindBeforeInMinutes: Long = 0L
) : Notification, CalendarNotification {

    /**
     * Name of the event.
     */
    protected abstract val name: String

    override val message: String
        get() = when (remindBeforeInMinutes) {
            0L   -> "$name is starting now!"
            1L   -> "$name will start in 1 minute!"
            else -> "$name will start in $remindBeforeInMinutes minutes!"
        }

    /**
     * List of times when event starts.
     */
    private val calendar = mutableSetOf<LocalTime>()

    protected fun addToCalendar(hour: Int, minute: Int) {
        calendar.add(LocalTime.of(hour, minute).minusMinutes(remindBeforeInMinutes))
    }

    override fun inCalendar(now: Instant): Boolean {
        return calendar.contains(now.toLocalTime())
    }
}

private fun Instant.toLocalTime(): LocalTime {
    return LocalTime.from(this.atZone(ZoneId.systemDefault())).truncatedTo(ChronoUnit.SECONDS)
}
