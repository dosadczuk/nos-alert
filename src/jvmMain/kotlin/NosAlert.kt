import androidx.compose.runtime.Composable
import androidx.compose.ui.window.ApplicationScope
import androidx.compose.ui.window.Tray
import notification.NotificationChannel
import notification.NotificationScheduler
import notification.channel.SystemNotificationChannel
import notification.event.AsgobasInstantCombatNotification
import notification.event.InstantCombatNotification

@Composable
fun ApplicationScope.NosAlert(state: NosAlertState) {
    val channels = listOf<NotificationChannel>(
        SystemNotificationChannel(state.tray)
    )

    val scheduler = NotificationScheduler(channels)
    // Instant Combat
    scheduler.schedule(InstantCombatNotification())
    scheduler.schedule(InstantCombatNotification(remindBeforeMinutes = 1))
    scheduler.schedule(InstantCombatNotification(remindBeforeMinutes = 5))
    // Asgobas' Instant Combat
    scheduler.schedule(AsgobasInstantCombatNotification())
    scheduler.schedule(AsgobasInstantCombatNotification(remindBeforeMinutes = 1))
    scheduler.schedule(AsgobasInstantCombatNotification(remindBeforeMinutes = 5))

    ApplicationTray(state)
}

@Composable
private fun ApplicationScope.ApplicationTray(state: NosAlertState) {
    Tray(
        LocalResources.current.icon,
        tooltip = "NosAlert",
        state = state.tray,
        menu = {
            Item("Exit", onClick = ::exitApplication)
        }
    )
}