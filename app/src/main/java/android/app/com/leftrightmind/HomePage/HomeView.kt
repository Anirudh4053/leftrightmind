package android.app.com.leftrightmind.HomePage

import android.app.com.leftrightmind.Model.DashResponse

interface HomeView {
    //fun hideProgress()
    fun responseError(msg:String)
    fun onSuccess(dashResponse: DashResponse)
}