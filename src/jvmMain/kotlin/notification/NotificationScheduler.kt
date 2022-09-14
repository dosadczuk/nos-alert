package notification

import java.time.Clock
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.TimeUnit

class NotificationScheduler(
    private val listeners: List<NotificationListener>,
    private val scheduler: ScheduledExecutorService = Executors.newScheduledThreadPool(1),
    private val clock: Clock = Clock.systemDefaultZone()
) {

    fun schedule(notification: Notification) {
        scheduler.scheduleAtFixedRate(
            {
                if (notification.canPush(clock.instant())) {
                    listeners.forEach { it.push(notification) }
                }
            },
            0, // initial delay
            1, // period
            TimeUnit.SECONDS
        )
    }
}