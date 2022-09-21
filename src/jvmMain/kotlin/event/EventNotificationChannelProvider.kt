package event

import core.AbstractNotificationChannelProvider
import core.NotificationChannel
import event.type.AsgobasInstantCombatNotification
import event.type.ClassicInstantCombatNotification

class EventNotificationChannelProvider(channels: List<NotificationChannel>) : AbstractNotificationChannelProvider() {

    init {
        provide(AsgobasInstantCombatNotification::class, channels)
        provide(ClassicInstantCombatNotification::class, channels)
    }
}