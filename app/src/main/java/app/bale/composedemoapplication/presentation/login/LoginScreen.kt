package app.bale.composedemoapplication.presentation.login

import android.widget.Toast
import androidx.compose.foundation.Image
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
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.bale.composedemoapplication.R
import app.bale.composedemoapplication.presentation.theme.TextFieldTextColor
import app.bale.composedemoapplication.presentation.theme.whiteBackground

// Android Studio provides an awesome feature of previewing your Compose UI
// elements while writing the code.
@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DefaultPreview() {
    LoginPage(loginViewModel = LoginViewModel.composeViewModel)
}

@Composable
fun LoginPage(loginViewModel: ILoginViewModel) {

    val context = LocalContext.current

    // rememberSaveable helps to save the state even after configuration changes.
    val emailValue = rememberSaveable { mutableStateOf("") }
    val passwordValue = rememberSaveable { mutableStateOf("") }

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

        PurposeImage()

        Text(
            text = stringResource(R.string.login_title),
            fontSize = 38.sp,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.padding(20.dp))

        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            InputField(
                label = stringResource(R.string.email_address),
                placeholder = stringResource(R.string.email_placeholder),
                state = emailValue
            )

            InputField(
                label = stringResource(R.string.password_label),
                placeholder = stringResource(R.string.password_placeholder),
                state = passwordValue,
                visualTransformation = PasswordVisualTransformation()
            )

            SignIn(isEnabled = true) {
                // Do login
                loginViewModel.doLogin(emailValue.value, passwordValue.value)

                // Check Result
                val result = loginViewModel.result.value

                // Print it !
                Toast.makeText(
                    context,
                    if (result.username.isEmpty()) "Login Result: Invalid Credentials" else "Login Result: Welcome ${result.username} !!",
                    Toast.LENGTH_LONG
                ).show()

            }

            ForgotPasswordText()
        }

    }
}

@Composable
fun PurposeImage() {
    Image(
        painter = painterResource(id = R.drawable.logo),
        contentDescription = "Application Icon",
        modifier = Modifier.size(150.dp)
    )
}

@Composable
fun InputField(
    label: String,
    placeholder: String,
    state: MutableState<String>,
    visualTransformation: VisualTransformation = VisualTransformation.None
) {

    OutlinedTextField(
        value = state.value,
        onValueChange = { state.value = it },
        label = { Text(text = label) },
        visualTransformation = visualTransformation,
        placeholder = { Text(text = placeholder) },
        singleLine = true,
        modifier = Modifier.fillMaxWidth(8.8f)
    )
}

@Composable
fun SignIn(isEnabled: Boolean, onClickAction: () -> Unit) {

    Button(
        onClick = { onClickAction.invoke() },
        enabled = isEnabled,
        modifier = Modifier
            .padding(top = 25.dp)
            .requiredWidth(277.dp)
    ) {
        Text(text = stringResource(R.string.sign_in_button))
    }
}

@Composable
fun ForgotPasswordText() {
    Text(
        text = stringResource(R.string.forgot_password_link),
        color = MaterialTheme.colors.TextFieldTextColor,
        modifier = Modifier.padding(top = 70.dp)
    )
}