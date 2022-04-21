package app.bale.composedemoapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import app.bale.composedemoapplication.presentation.theme.ComposeDemoApplicationTheme
import app.bale.composedemoapplication.ui.login.LoginPage
import app.bale.composedemoapplication.ui.login.LoginViewModel

class MainActivity : ComponentActivity() {

    lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            loginViewModel = ViewModelProvider(this)[LoginViewModel::class.java]

            ComposeDemoApplicationTheme {
                LoginApplication(loginViewModel)
            }
        }
    }
}

// Always start Jetpack Composable function name with a Capital Letter
@Composable
fun LoginApplication(loginViewModel: LoginViewModel) {

    LoginPage(loginViewModel)
}

// Android Studio provides an awesome feature of previewing your Compose UI elements while writing the code.
@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DefaultPreview() {
    ComposeDemoApplicationTheme {
        //LoginApplication()
    }
}