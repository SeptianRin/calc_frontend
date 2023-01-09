package space.septianrin.simpleonlinecalculator.models

import com.google.gson.annotations.SerializedName

data class BackendResponse(
    @SerializedName("status")
    val status: Int,

    @SerializedName("message")
    val message: String,

    @SerializedName("data")
    val data: String,
)