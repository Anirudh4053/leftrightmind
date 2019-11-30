package android.app.com.leftrightmind.Model
import com.google.gson.annotations.SerializedName


data class LoginRequest(
    @SerializedName("appLanguagePref") val appLanguagePref: String,
    @SerializedName("password") val password: String,
    @SerializedName("userName") val userName: String,
    @SerializedName("userType") val userType: String
)
data class LoginResponse(
    @SerializedName("data") val `data`: List<Data>,
    @SerializedName("message") val message: String,
    @SerializedName("status") val status: Boolean,
    @SerializedName("statusCode") val statusCode: Int
)

data class Data(
    @SerializedName("access_token") val accessToken: String,
    @SerializedName("appLanguagePref") val appLanguagePref: String,
    @SerializedName("expires_in") val expiresIn: String,
    @SerializedName("firstName") val firstName: String,
    @SerializedName("isAllowed") val isAllowed: Boolean,
    @SerializedName("isFirstLoginStatus") val isFirstLoginStatus: Boolean,
    @SerializedName("isOtpVerifiedStatus") val isOtpVerifiedStatus: Boolean,
    @SerializedName("lastName") val lastName: String,
    @SerializedName("mobileNumber") val mobileNumber: String,
    @SerializedName("profilePicUrl") val profilePicUrl: String,
    @SerializedName("refresh_token") val refreshToken: String,
    @SerializedName("roles") val roles: List<String>,
    @SerializedName("scope") val scope: String,
    @SerializedName("token_type") val tokenType: String,
    @SerializedName("userName") val userName: String,
    @SerializedName("userType") val userType: String
)

