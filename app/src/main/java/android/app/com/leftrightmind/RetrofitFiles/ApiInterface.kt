package android.app.com.leftrightmind.RetrofitFiles

import android.app.com.leftrightmind.Global.CUSTBASEURL
import android.app.com.leftrightmind.Model.DashResponse
import android.app.com.leftrightmind.Model.LoginRequest
import android.app.com.leftrightmind.Model.LoginResponse
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface ApiInterface {
    @POST("/shriramfa/api/v1.0/auth/login")
    fun loginUser(@Body loginRequest: LoginRequest): Call<LoginResponse>

    @GET("/shriramfa/api/v1.0/connections/connections/all?limit=10")
    fun getData(@Header("Authorization") token:String, @Query("offset") offset:Int): Call<DashResponse>
}

object ApiUrl{
    val api: ApiInterface
    init {
        var httpClient: OkHttpClient.Builder = OkHttpClient.Builder();
        httpClient.addInterceptor {
            val original: Request = it.request()
            val request = original.newBuilder()
                .header("Content-Type", "application/json")
                .method(original.method, original.body)
                .build()
            it.proceed(request)
        }

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        httpClient.addInterceptor(interceptor)
        /*val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()*/
        val gson = GsonBuilder()
            .setLenient()
            .create()

        val retrofit = Retrofit.Builder()
            .client(httpClient.build())
            .baseUrl(CUSTBASEURL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        api = retrofit.create(ApiInterface::class.java)
    }

}

