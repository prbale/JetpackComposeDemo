package app.bale.composedemoapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import app.bale.composedemoapplication.composables.LoginPage
import app.bale.composedemoapplication.ui.theme.ComposeDemoApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDemoApplicationTheme {
                LoginApplication()
            }
        }
    }
}

@Composable
fun LoginApplication() {
    LoginPage()
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeDemoApplicationTheme {
    }
}