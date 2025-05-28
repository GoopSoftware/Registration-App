package com.dzl.registrationform

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class IntentManager(
    val firstName: String,
    val lastName: String,
    val title: String,
    val email: String,
    val phoneNumber: String,
    val password: String

) : Parcelable {




}
