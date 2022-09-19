package core

import java.time.Instant

/**
 * Notification based on calendar, pushed only in certain dates and times.
 */
interface CalendarNotification {

    /**
     * Check if notification is scheduled in calendar.
     */
    fun inCalendar(now: Instant): Boolean
}