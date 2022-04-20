package app.bale.composedemoapplication.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.bale.composedemoapplication.ui.theme.whiteBackground

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
            text = "Sign In",
            fontSize = 38.sp
        )
        Spacer(modifier = Modifier.padding(20.dp))

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            OutlinedTextField(
                value = emailValue.value,
                onValueChange = { emailValue.value = it },
                label = { Text(text = "Email Address") },
                placeholder = { Text(text = "Email Address")},
                singleLine = true,
                modifier = Modifier.fillMaxWidth(8.8f)
            )

            OutlinedTextField(
                value = passwordValue.value,
                onValueChange = { passwordValue.value = it },
                label = { Text(text = "Password") },
                placeholder = { Text(text = "Password")},
                singleLine = true,
                modifier = Modifier.fillMaxWidth(8.8f)
            )
        }
        
    }
    
}