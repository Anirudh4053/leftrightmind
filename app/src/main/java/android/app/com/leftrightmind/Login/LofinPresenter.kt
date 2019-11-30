package android.app.com.leftrightmind.Login

import android.app.com.leftrightmind.Global.ERROR
import android.app.com.leftrightmind.Global.NETWORKERROR
import android.app.com.leftrightmind.Model.LoginRequest
import android.app.com.leftrightmind.Model.LoginResponse
import android.app.com.leftrightmind.RetrofitFiles.ApiUrl
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginPresenter(loginView:LoginView) {
    private var loginView: LoginView? = loginView
    fun loginClick(phoneNumber: String, pwd: String) {
        ApiUrl.api.loginUser(LoginRequest("en",pwd,phoneNumber,"USERTYPE_EXISTING")).enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (loginView != null) {
                    loginView?.hideProgress()
                    val resp = response.body()
                    println("res $resp")

                    if(resp!=null){
                        if(resp.status){
                            loginView?.loginSuccessFully(resp)
                        }
                        else{
                            loginView?.responseError(ERROR)
                        }
                    }
                    else{
                        loginView?.responseError(ERROR)
                    }

                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                if (loginView != null) {
                    loginView?.hideProgress()
                    loginView?.responseError(NETWORKERROR)
                }
            }
        })
    }
}