package event.type

import event.EventNotification

class AsgobasInstantCombatNotification(remindBeforeInMinutes: Long = 0L) : EventNotification(remindBeforeInMinutes) {

    override val name = "Asgobas' Instant Combat"

    init {
        addToCalendar(11, 30)
        addToCalendar(17, 30)
        addToCalendar(21, 30)
        addToCalendar(23, 30)
    }
}