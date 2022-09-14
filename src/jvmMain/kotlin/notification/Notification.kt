package notification

import java.time.Instant

interface Notification {

    /**
     * Notification message.
     */
    val message: String

    /**
     * Check notification can be pushed.
     */
    fun canPush(now: Instant): Boolean
}