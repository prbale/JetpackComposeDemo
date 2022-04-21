package app.bale.composedemoapplication.ui.login

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.bale.composedemoapplication.domain.model.LoginResponse
import kotlinx.coroutines.launch

class LoginViewModel: ViewModel() {

    val result : MutableState<LoginResponse> = mutableStateOf(LoginResponse(0, ""))

    fun doLogin(email: String, password: String) {

        viewModelScope.launch {

            if(email == "prashant@gmail.com" && password == "bale")
                result.value = LoginResponse(200, "prbale")
            else
                result.value = LoginResponse(400, "")

        }
    }
}