package app.bale.composedemoapplication.domain.model

import androidx.compose.runtime.Immutable

@Immutable
data class LoginResponse(
    var status: Int = 0,
    var username: String = ""
)