package app.bale.composedemoapplication.presentation.login

import androidx.compose.runtime.MutableState
import app.bale.composedemoapplication.domain.model.LoginResponse

interface ILoginViewModel {

    val result: MutableState<LoginResponse>

    fun doLogin(email: String, password: String)
}
