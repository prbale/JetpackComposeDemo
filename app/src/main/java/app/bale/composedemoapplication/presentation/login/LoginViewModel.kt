package app.bale.composedemoapplication.presentation.login

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.bale.composedemoapplication.domain.model.LoginResponse
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    val result: MutableState<LoginResponse> = mutableStateOf(LoginResponse(0, ""))

    fun doLogin(email: String, password: String) {

        viewModelScope.launch {

            result.value = if (email == "prashant@gmail.com" && password == "bale")
                LoginResponse(200, "prbale")
            else
                LoginResponse(400, "")

        }
    }
}