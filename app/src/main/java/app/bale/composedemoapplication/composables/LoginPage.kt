package app.bale.composedemoapplication.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.bale.composedemoapplication.ui.theme.ComposeDemoApplicationTheme
import app.bale.composedemoapplication.ui.theme.TextFieldTextColor
import app.bale.composedemoapplication.ui.theme.whiteBackground

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DefaultPreview() {
    ComposeDemoApplicationTheme {
        LoginPage()
    }
}

@Composable
fun LoginPage() {

    val emailValue = remember { mutableStateOf("") }
    val passwordValue = remember { mutableStateOf("") }

    // ----------------- Display Image ---------------
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            contentAlignment = Alignment.TopCenter
        ) {

        }
    }

    // ----------------- Display Inputs ---------------

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(8.68f)
            .clip(RoundedCornerShape(topStart = 38.dp, topEnd = 38.dp))
            .background(whiteBackground)
            .padding(10.dp)
    ) {
        Text(
            text = "Login",
            fontSize = 38.sp
        )
        Spacer(modifier = Modifier.padding(20.dp))

        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            InputField(
                label = "Email Address",
                placeholder = "Enter Email Address here",
                state = emailValue
            )

            InputField(
                label = "Password",
                placeholder = "Enter your password here",
                state = passwordValue
            )

            SignIn()

            ForgotPasswordText()
        }
        
    }
}

@Composable
fun InputField(label: String, placeholder: String, state: MutableState<String>) {
    OutlinedTextField(
        value = state.value,
        onValueChange = { state.value = it },
        label = { Text(text = label) },
        placeholder = { Text(text = placeholder)},
        singleLine = true,
        modifier = Modifier.fillMaxWidth(8.8f)
    )
}

// You can have as many preview functions as you want.
@Preview
@Composable
fun SignInButtonPreview() = SignIn()

@Composable
fun SignIn(){
    Button(onClick = {},modifier = Modifier
        .padding(top = 25.dp)
        .requiredWidth(277.dp)){
        Text(text = "Sign In")
    }
}

@Composable
fun ForgotPasswordText(){
    Text(text = "Forgot Password ?",color = MaterialTheme.colors.TextFieldTextColor,
        modifier = Modifier.padding(top = 70.dp))
}