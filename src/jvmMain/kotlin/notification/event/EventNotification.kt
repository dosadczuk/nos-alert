package notification.event

import notification.Notification
import java.time.Instant
import java.time.LocalTime
import java.time.ZoneId
import java.time.temporal.ChronoUnit

/**
 * Notification for in-game event.
 *
 * @constructor
 * @property remindBeforeMinutes Offset to every schedule time (in minutes).
 * @property availableOnChannels List of channels the event is available on.
 */
abstract class EventNotification(
    private val remindBeforeMinutes: Long = 0L,
    private val availableOnChannels: Set<Int> = emptySet()
) : Notification {

    protected abstract val event: String

    override val message: String
        get() {
            val builder = StringBuilder()
            builder.appendLine(
                when (remindBeforeMinutes) {
                    0L   -> "$event is starting now!"
                    1L   -> "$event will start in 1 minute!"
                    else -> "$event will start in $remindBeforeMinutes minutes!"
                }
            )

            if (availableOnChannels.isNotEmpty()) {
                builder.appendLine("Channels: " + availableOnChannels.joinToString(", "))
            }

            return builder.toString()
        }

    private val schedule = mutableListOf<LocalTime>()

    protected fun addTime(time: LocalTime) {
        schedule.add(time.minusMinutes(remindBeforeMinutes))
    }

    override fun canPush(now: Instant): Boolean {
        val currentTime = LocalTime.from(now.atZone(ZoneId.systemDefault())).truncatedTo(ChronoUnit.SECONDS)

        return schedule.binarySearch { it.compareTo(currentTime) } >= 0
    }
}