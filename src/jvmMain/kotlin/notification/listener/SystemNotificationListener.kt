package notification.listener

import androidx.compose.ui.window.TrayState
import notification.Notification
import notification.NotificationListener
import androidx.compose.ui.window.Notification as SystemNotification

class SystemNotificationListener(private val controller: TrayState) : NotificationListener {

    override fun push(notification: Notification) {
        controller.sendNotification(
            SystemNotification("NosAlert", notification.message)
        )
    }
}
