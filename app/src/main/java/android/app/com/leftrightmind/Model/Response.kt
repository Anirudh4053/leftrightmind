package android.app.com.leftrightmind.Model

import com.google.gson.annotations.SerializedName

data class DashResponse(
    @SerializedName("data")
    val `data`: List<DashData>,
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: Boolean,
    @SerializedName("statusCode")
    val statusCode: Int,
    @SerializedName("totalCount")
    val totalCount: Int
)

data class DashData(
    @SerializedName("address")
    val address: String,
    @SerializedName("adviceGiven")
    val adviceGiven: String,
    @SerializedName("age")
    val age: String,
    @SerializedName("alternateMobileNumber")
    val alternateMobileNumber: String,
    @SerializedName("alternativeNumber")
    val alternativeNumber: String,
    @SerializedName("convertedToLead")
    val convertedToLead: Boolean,
    @SerializedName("createdDate")
    val createdDate: String,
    @SerializedName("dob")
    val dob: String,
    @SerializedName("educationalExpense")
    val educationalExpense: String,
    @SerializedName("educationalQualification")
    val educationalQualification: String,
    @SerializedName("emiExpense")
    val emiExpense: String,
    @SerializedName("expense")
    val expense: String,
    @SerializedName("familyFinancialInsecurity")
    val familyFinancialInsecurity: String,
    @SerializedName("familyFutureLiability")
    val familyFutureLiability: String,
    @SerializedName("familyLifeStyleInsecurity")
    val familyLifeStyleInsecurity: String,
    @SerializedName("familyMembers")
    val familyMembers: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("iWish")
    val iWish: String,
    @SerializedName("iWouldRather")
    val iWouldRather: String,
    @SerializedName("income")
    val income: String,
    @SerializedName("isLACompleted")
    val isLACompleted: Boolean,
    @SerializedName("isLifelineDocumentUploaded")
    val isLifelineDocumentUploaded: Boolean,
    @SerializedName("isSelfCompleted")
    val isSelfCompleted: Boolean,
    @SerializedName("jobInsecurity")
    val jobInsecurity: String,
    @SerializedName("leadFor")
    val leadFor: String,
    @SerializedName("lifelineDocuments")
    val lifelineDocuments: List<String>,
    @SerializedName("meraDhanCompleted")
    val meraDhanCompleted: Boolean,
    @SerializedName("mereSapneCompleted")
    val mereSapneCompleted: Boolean,
    @SerializedName("meriDuniyaCompleted")
    val meriDuniyaCompleted: Boolean,
    @SerializedName("mobileNumber")
    val mobileNumber: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("notes")
    val notes: String,
    @SerializedName("overallInsecurity")
    val overallInsecurity: String,
    @SerializedName("profession")
    val profession: String,
    @SerializedName("riskOnEventualityToFamily")
    val riskOnEventualityToFamily: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("suggestionCompleted")
    val suggestionCompleted: Boolean,
    @SerializedName("surplus_deficit")
    val surplusDeficit: String
)