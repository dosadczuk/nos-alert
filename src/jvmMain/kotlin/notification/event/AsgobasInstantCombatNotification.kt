package notification.event

import java.time.LocalTime

class AsgobasInstantCombatNotification(remindBeforeMinutes: Long = 0L) :
    EventNotification(remindBeforeMinutes, availableOnChannels = setOf(1, 2)) {

    override val event: String = "Asgobas' Instant Combat"

    init {
        val times = listOf<LocalTime>(
            LocalTime.of(11, 30),
            LocalTime.of(17, 30),
            LocalTime.of(21, 30),
            LocalTime.of(23, 30)
        )
        times.forEach(::addTime)
    }
}