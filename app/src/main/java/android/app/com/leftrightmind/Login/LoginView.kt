package android.app.com.leftrightmind.Login

import android.app.com.leftrightmind.Model.LoginResponse

interface LoginView {
    fun hideProgress()
    fun responseError(msg:String)
    fun loginSuccessFully(loginResponse: LoginResponse)
}