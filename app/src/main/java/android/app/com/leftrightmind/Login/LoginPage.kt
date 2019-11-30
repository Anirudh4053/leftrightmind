package android.app.com.leftrightmind.Login

import android.app.com.leftrightmind.Global.showToast
import android.app.com.leftrightmind.R
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login_page.*

class LoginPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        loginBtn.setOnClickListener {
            if(!validatePhNumber() || !validatePassword()){
                return@setOnClickListener
            }
            else{
                val phNumber = phnNumber.text.toString().trim()
                val password = pwd.text.toString().trim()
                println("$phNumber -- $password")
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
}
