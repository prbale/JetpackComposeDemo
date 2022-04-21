package app.bale.composedemoapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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

// Always start Jetpack Composable function name with a Capital Letter
@Composable
fun LoginApplication() {
    LoginPage()
}

// Android Studio provides an awesome feature of previewing your Compose UI elements while writing the code.
@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DefaultPreview() {
    ComposeDemoApplicationTheme {
        LoginApplication()
    }
}