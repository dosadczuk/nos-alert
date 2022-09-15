package notification.channel

import androidx.compose.ui.window.TrayState
import notification.Notification
import notification.NotificationChannel
import androidx.compose.ui.window.Notification as SystemNotification

class SystemNotificationChannel(private val controller: TrayState) : NotificationChannel {

    override fun push(notification: Notification) {
        controller.sendNotification(
            SystemNotification("NosAlert", notification.message)
        )
    }
}
