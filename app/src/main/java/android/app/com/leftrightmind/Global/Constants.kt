package android.app.com.leftrightmind.Global

import android.content.Context
import android.view.Window
import android.view.WindowManager
import android.widget.Toast

const val CUSTBASEURL = "http://108.161.129.11:8081"
const val ERROR = "Something went wrong. Please try again"
const val NETWORKERROR = "Network Error"
//hide show loader
fun Window.disableUserInteraction(){
    this.setFlags(
        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
}

fun Window.enableUserInteraction(){
    this.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
}
fun Context.showToast(text: CharSequence, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, text, duration).show()
}
