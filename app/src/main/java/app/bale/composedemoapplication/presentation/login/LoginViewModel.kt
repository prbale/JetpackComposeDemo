package app.bale.composedemoapplication.presentation.login

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.bale.composedemoapplication.domain.model.LoginResponse
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel(), ILoginViewModel {

    override val result: MutableState<LoginResponse> = mutableStateOf(LoginResponse(0, ""))

    override fun doLogin(email: String, password: String) {

        viewModelScope.launch {

            result.value = if (email == "prashant@gmail.com" && password == "bale")
                LoginResponse(200, "prbale")
            else
                LoginResponse(400, "")

        }
    }

    // Need to have this companion object when we need to pass viewmodel instance in
    // composable preview function.
    companion object {
        val composeViewModel =
            object : ILoginViewModel {
                override val result: MutableState<LoginResponse>
                    get() = mutableStateOf(LoginResponse(0, ""))

                override fun doLogin(email: String, password: String) {}
            }
    }
}