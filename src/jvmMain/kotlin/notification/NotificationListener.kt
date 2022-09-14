package notification

interface NotificationListener {

    /**
     * Push notification.
     */
    fun push(notification: Notification)
}