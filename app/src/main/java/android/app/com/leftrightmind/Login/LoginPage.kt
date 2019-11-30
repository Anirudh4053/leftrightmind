package android.app.com.leftrightmind.Login

import android.app.com.leftrightmind.Global.LoginPref
import android.app.com.leftrightmind.Global.showToast
import android.app.com.leftrightmind.HomePage.MainActivity
import android.app.com.leftrightmind.Model.LoginResponse
import android.app.com.leftrightmind.R
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login_page.*

class LoginPage : AppCompatActivity(),LoginView {


    private lateinit var presenter:LoginPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)



        supportActionBar?.title = "Login"
        if(LoginPref.getLogIn(this,"login")==1){
            val i = Intent(this,MainActivity::class.java)
            startActivity(i)
            finish()
        }
        presenter = LoginPresenter(this)
        loginBtn.setOnClickListener {
            if(!validatePhNumber() || !validatePassword()){
                return@setOnClickListener
            }
            else{
                val phNumber = phnNumber.text.toString().trim()
                val password = pwd.text.toString().trim()
                println("$phNumber -- $password")
                presenter.loginClick(phNumber,password)
            }
        }
    }
    private fun validatePhNumber():Boolean{
        val phNumber = phnNumber.text.toString().trim()
        if(phNumber.isNullOrEmpty()){
            showToast("Phone Number is required")
            return false
        }
        return true
    }

    private fun validatePassword():Boolean{
        val pass = pwd.text.toString().trim()
        if(pass.isNullOrEmpty()){
            showToast("Password is required")
            return false
        }
        return true
    }
    override fun hideProgress() {

    }

    override fun responseError(msg: String) {
        showToast(msg)

    }

    override fun loginSuccessFully(loginResponse: LoginResponse) {
        showToast(loginResponse.message)
        LoginPref.setLogIn(this,"login",1)
        LoginPref.setAccessToken(this,"accessToken",loginResponse.data[0].accessToken)
        //LoginPref.setRefreshToken(this,"refreshToken",loginResponse.data[0].refreshToken)
        //LoginPref.setTokenType(this,"tokenType",loginResponse.data[0].tokenType)
        val i = Intent(this,MainActivity::class.java)
        startActivity(i)
        finish()
    }

}
