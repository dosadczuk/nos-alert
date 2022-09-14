package notification.event

import notification.Notification
import java.time.Instant
import java.time.LocalTime
import java.time.ZoneId
import java.time.temporal.ChronoUnit

class InstantCombatNotification(private val remindBeforeMinutes: Long = 0L) : Notification {

    override val message: String
        get() {
            return when (remindBeforeMinutes) {
                0L   -> "Instant Combat is starting now!"
                1L   -> "Instant Combat will start in 1 minute!"
                else -> "Instant Combat will start in $remindBeforeMinutes minutes!"
            }
        }

    private val schedule = mutableListOf<LocalTime>()

    init {
        for (hour in 0 until 23 step 2) {
            schedule.add(LocalTime.of(hour, 0, 0).minusMinutes(remindBeforeMinutes))
        }
    }

    override fun canPush(now: Instant): Boolean {
        val currentTime = LocalTime.from(now.atZone(ZoneId.systemDefault())).truncatedTo(ChronoUnit.SECONDS)

        return schedule.binarySearch { it.compareTo(currentTime) } >= 0
    }
}