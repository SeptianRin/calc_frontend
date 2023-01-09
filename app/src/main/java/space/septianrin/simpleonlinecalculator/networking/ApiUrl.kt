package space.septianrin.simpleonlinecalculator.networking

import com.google.gson.JsonObject
import io.reactivex.rxjava3.core.Single
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import space.septianrin.simpleonlinecalculator.models.BackendResponse

interface ApiUrl {
    @Headers("Content-Type: application/json")
    @POST("add")
    fun add(
        @Body frontendRequest: JsonObject
    ): Single<BackendResponse>

    @Headers("Content-Type: application/json")
    @POST("substract")
    fun substract(
        @Body frontendRequest: JsonObject
    ): Single<BackendResponse>

    @Headers("Content-Type: application/json")
    @POST("multiply")
    fun multiply(
        @Body frontendRequest: JsonObject
    ): Single<BackendResponse>

    @Headers("Content-Type: application/json")
    @POST("divide")
    fun divide(
        @Body frontendRequest: JsonObject
    ): Single<BackendResponse>

    @Headers("Content-Type: application/json")
    @POST("spliteq")
    fun spliteq(
        @Body frontendRequest: JsonObject
    ): Single<BackendResponse>

    @Headers("Content-Type: application/json")
    @POST("splitnum")
    fun splitnum(
        @Body frontendRequest: JsonObject
    ): Single<BackendResponse>

}