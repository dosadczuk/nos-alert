package event.type

import event.EventNotification
import java.time.LocalTime

class AsgobasInstantCombatNotification(remindBeforeInMinutes: Long = 0L) : EventNotification(remindBeforeInMinutes) {

    override val name = "Asgobas' Instant Combat"

    init {
        addToCalendar(LocalTime.of(11, 30))
        addToCalendar(LocalTime.of(17, 30))
        addToCalendar(LocalTime.of(21, 30))
        addToCalendar(LocalTime.of(23, 30))
    }
}