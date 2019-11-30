package android.app.com.leftrightmind.HomePage

import android.app.com.leftrightmind.Global.ERROR
import android.app.com.leftrightmind.Global.NETWORKERROR
import android.app.com.leftrightmind.Login.LoginView
import android.app.com.leftrightmind.Model.DashResponse
import android.app.com.leftrightmind.Model.LoginRequest
import android.app.com.leftrightmind.Model.LoginResponse
import android.app.com.leftrightmind.RetrofitFiles.ApiUrl
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomePresenter(homeView: HomeView) {
    private var homeView: HomeView? = homeView
    fun getDataListing(token: String, offset: Int) {
        ApiUrl.api.getData(token,offset).enqueue(object :
            Callback<DashResponse> {
            override fun onResponse(call: Call<DashResponse>, response: Response<DashResponse>) {
                if (homeView != null) {
                    val resp = response.body()
                    println("res $resp")

                    if(resp!=null){
                        if(resp.status){
                            homeView?.onSuccess(resp)
                        }
                        else{
                            homeView?.responseError(ERROR)
                        }
                    }
                    else{
                        homeView?.responseError(ERROR)
                    }

                }
            }

            override fun onFailure(call: Call<DashResponse>, t: Throwable) {
                if (homeView != null) {
                    homeView?.responseError(NETWORKERROR)
                }
            }
        })
    }
}