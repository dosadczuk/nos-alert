package core

import java.time.Clock

class NotificationDispatcher(
    private val provider: NotificationChannelProvider,
    private val clock: Clock = Clock.systemDefaultZone()
) {

    /**
     * Dispatch notification to all the provided channels.
     */
    fun dispatch(notification: Notification): Notification {
        provider.getChannels(notification::class).forEach { channel ->
            if (notification is CalendarNotification && !notification.inCalendar(clock.instant())) {
                return@forEach
            }

            channel.push(notification)
        }

        return notification
    }
}