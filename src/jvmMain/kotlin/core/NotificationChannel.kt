package core

interface NotificationChannel {

    /**
     * Push notification into the channel.
     */
    fun push(notification: Notification)
}