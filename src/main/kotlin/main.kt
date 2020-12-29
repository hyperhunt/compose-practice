import androidx.compose.desktop.AppWindowAmbient
import androidx.compose.desktop.Window
import androidx.compose.material.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp

const val DEFAULT_WIDTH = 300
const val DEFAULT_HEIGHT = 150

fun main() {
//    val windowPos = mutableStateOf(IntOffset.Zero)

    Window(
            title = "Kotlin Jetpack Compose",
            size = IntSize(DEFAULT_WIDTH, DEFAULT_HEIGHT),
/*            events = WindowEvents(
                    onRelocate = { location -> windowPos.value = location }
            ),*/
            centered = false,
    )
    {
        var windowSize by remember { mutableStateOf(IntSize.Zero) }
        var windowLocation by remember { mutableStateOf(IntOffset.Zero) }
        AppWindowAmbient.current?.apply {
            events.onResize = { windowSize = it }
            events.onRelocate = { windowLocation = it }
        }

        Box(
                modifier = Modifier.fillMaxSize().background(color = Color(40, 44, 52)).padding(10.dp),
                contentAlignment = Alignment.Center
        ) {
            Text(text = "Location: ${windowLocation}\nSize: $windowSize", color = Color(192, 192, 192))
        }
    }
}
