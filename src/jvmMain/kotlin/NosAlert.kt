import androidx.compose.runtime.Composable
import androidx.compose.ui.window.ApplicationScope
import androidx.compose.ui.window.Tray
import core.MultipleNotificationChannelProvider
import core.NotificationDispatcher
import core.NotificationScheduler
import core.channel.SystemNotificationChannel
import event.EventNotificationChannelProvider
import event.type.AsgobasInstantCombatNotification
import event.type.ClassicInstantCombatNotification

@Composable
fun ApplicationScope.NosAlert(state: NosAlertState) {
    val channels = listOf(SystemNotificationChannel(state.tray))
    val provider = MultipleNotificationChannelProvider(
        EventNotificationChannelProvider(channels)
    )

    val scheduler = NotificationScheduler(NotificationDispatcher(provider))
    // Instant Combat
    scheduler.schedule(ClassicInstantCombatNotification(remindBeforeInMinutes = 1))
    scheduler.schedule(ClassicInstantCombatNotification(remindBeforeInMinutes = 5))
    // Asgobas' Instant Combat
    scheduler.schedule(AsgobasInstantCombatNotification(remindBeforeInMinutes = 1))
    scheduler.schedule(AsgobasInstantCombatNotification(remindBeforeInMinutes = 5))

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