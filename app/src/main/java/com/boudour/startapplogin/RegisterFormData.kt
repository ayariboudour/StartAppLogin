package com.boudour.startapplogin

import java.io.Serializable


data class RegisterFormData(
    val spinner: String,
    val firstName: String,
    val lastName: String,
    val email: String,
    val phoneNumber: String,
    val password: String
): Serializable{
    fun getFullName()= "$spinner $firstName $lastName"
}
