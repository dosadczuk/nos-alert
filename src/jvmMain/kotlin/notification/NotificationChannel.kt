package notification

interface NotificationChannel {

    /**
     * Push notification.
     */
    fun push(notification: Notification)
}