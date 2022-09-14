package notification.event

import java.time.LocalTime

class InstantCombatNotification(remindBeforeMinutes: Long = 0L) :
    EventNotification(remindBeforeMinutes, availableOnChannels = setOf(1, 2)) {

    override val event: String = "Instant Combat"

    init {
        for (hour in 0 until 23 step 2) {
            addTime(LocalTime.of(hour, 0))
        }
    }
}