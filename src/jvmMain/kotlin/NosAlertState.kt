import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.window.TrayState

@Composable
fun rememberApplicationState() = remember { NosAlertState() }

class NosAlertState {

    val tray = TrayState()
}