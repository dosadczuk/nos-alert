import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource

val LocalResources = staticCompositionLocalOf<NosAlertResources> {
    error("NosAlertResources isn't provided")
}

@Composable
fun rememberApplicationResources(): NosAlertResources {
    val icon = painterResource("icon.jpg")

    return remember { NosAlertResources(icon) }
}

class NosAlertResources(val icon: Painter)