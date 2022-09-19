package event

import core.AbstractNotificationChannelProvider
import core.NotificationChannel
import event.type.AsgobasInstantCombatNotification
import event.type.InstantCombatNotification

class EventNotificationChannelProvider(channels: List<NotificationChannel>) : AbstractNotificationChannelProvider() {

    init {
        provide(AsgobasInstantCombatNotification::class, channels)
        provide(InstantCombatNotification::class, channels)
    }
}