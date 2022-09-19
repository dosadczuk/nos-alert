package core

import kotlin.reflect.KClass

interface NotificationChannelProvider {

    /**
     * Get channels provided for the notification.
     */
    fun <T : Notification> getChannels(notification: KClass<T>): Collection<NotificationChannel>
}

/**
 * Base implementation of notification channel provider.
 */
abstract class AbstractNotificationChannelProvider : NotificationChannelProvider {

    private val channels = mutableMapOf<KClass<*>, MutableCollection<NotificationChannel>>()

    override fun <T : Notification> getChannels(notification: KClass<T>): Collection<NotificationChannel> {
        return this.channels.getOrDefault(notification, emptySet())
    }

    /**
     * Register channels for the notification.
     */
    protected fun <T : Notification> provide(notification: KClass<T>, channels: Collection<NotificationChannel>) {
        this.channels.getOrPut(notification) { mutableSetOf() }.addAll(channels)
    }
}

/**
 * Container to register multiple providers.
 */
class MultipleNotificationChannelProvider(vararg providers: NotificationChannelProvider) :
    AbstractNotificationChannelProvider() {

    private val providers = mutableSetOf<NotificationChannelProvider>()

    init {
        this.providers.addAll(providers)
    }

    override fun <T : Notification> getChannels(notification: KClass<T>): Collection<NotificationChannel> {
        return buildSet {
            for (provider in providers) {
                addAll(provider.getChannels(notification))
            }
        }
    }
}