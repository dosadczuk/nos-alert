package core

import java.time.Duration
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

class NotificationScheduler(
    private val dispatcher: NotificationDispatcher,
) {
    private val scheduler = Executors.newScheduledThreadPool(1)

    /**
     * Schedule notification to be pushed with given period.
     */
    fun schedule(notification: Notification, period: Duration = Duration.ofSeconds(1)) {
        scheduler.scheduleAtFixedRate(
            { dispatcher.dispatch(notification) },
            0, // initial delay
            period.toMillis(),
            TimeUnit.MILLISECONDS
        )
    }
}