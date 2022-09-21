package event.type

import event.EventNotification
import java.time.LocalTime

class ClassicInstantCombatNotification(remindBeforeInMinutes: Long = 0L) : EventNotification(remindBeforeInMinutes) {

    override val name = "Instant Combat"

    init {
        for (hour in 0 until 23 step 2) {
            addToCalendar(LocalTime.of(hour, 0))
        }
    }
}