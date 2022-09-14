import androidx.compose.ui.res.painterResource
import androidx.compose.ui.window.Tray
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberTrayState
import notification.NotificationListener
import notification.NotificationScheduler
import notification.event.AsgobasInstantCombatNotification
import notification.event.InstantCombatNotification
import notification.listener.SystemNotificationListener

fun main() = application {
    val trayState = rememberTrayState()

    val listeners = listOf<NotificationListener>(
        SystemNotificationListener(trayState)
    )

    val scheduler = NotificationScheduler(listeners)
    // Instant Combat
    scheduler.schedule(InstantCombatNotification())
    scheduler.schedule(InstantCombatNotification(remindBeforeMinutes = 1))
    scheduler.schedule(InstantCombatNotification(remindBeforeMinutes = 5))
    // Asgobas' Instant Combat
    scheduler.schedule(AsgobasInstantCombatNotification())
    scheduler.schedule(AsgobasInstantCombatNotification(remindBeforeMinutes = 1))
    scheduler.schedule(AsgobasInstantCombatNotification(remindBeforeMinutes = 5))

    Tray(
        tooltip = "NosAlert",
        state = trayState,
        icon = painterResource("icon.jpg"),
        menu = {
            Item("Exit", onClick = ::exitApplication)
        }
    )
}
