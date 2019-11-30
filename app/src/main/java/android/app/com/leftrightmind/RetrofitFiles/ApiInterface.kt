package android.app.com.leftrightmind.RetrofitFiles

import android.app.com.leftrightmind.Global.CUSTBASEURL
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface ApiInterface {

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