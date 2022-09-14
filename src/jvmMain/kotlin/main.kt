import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.window.application

fun main() = application {
    CompositionLocalProvider(LocalResources provides rememberApplicationResources()) {
        NosAlert(rememberApplicationState())
    }
}
