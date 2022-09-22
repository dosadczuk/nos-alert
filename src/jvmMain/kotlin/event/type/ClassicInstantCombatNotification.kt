package event.type

import event.EventNotification

class ClassicInstantCombatNotification(remindBeforeInMinutes: Long = 0L) : EventNotification(remindBeforeInMinutes) {

    override val name = "Instant Combat"

    init {
        for (hour in 0 until 23 step 2) {
            addToCalendar(hour, minute = 0)
        }
    }
}