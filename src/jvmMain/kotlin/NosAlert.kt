import androidx.compose.runtime.Composable
import androidx.compose.ui.window.ApplicationScope
import androidx.compose.ui.window.Tray
import notification.NotificationListener
import notification.NotificationScheduler
import notification.event.AsgobasInstantCombatNotification
import notification.event.InstantCombatNotification
import notification.listener.SystemNotificationListener

@Composable
fun ApplicationScope.NosAlert(state: NosAlertState) {
    val listeners = listOf<NotificationListener>(
        SystemNotificationListener(state.tray)
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