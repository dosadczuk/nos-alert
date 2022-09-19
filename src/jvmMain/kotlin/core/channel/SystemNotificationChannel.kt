package core.channel

import androidx.compose.ui.window.TrayState
import core.Notification
import core.NotificationChannel
import androidx.compose.ui.window.Notification as SystemNotification

/**
 * System-native notification.
 */
class SystemNotificationChannel(private val controller: TrayState) : NotificationChannel {

    override fun push(notification: Notification) {
        controller.sendNotification(
            SystemNotification("NosAlert", notification.message)
        )
    }
}