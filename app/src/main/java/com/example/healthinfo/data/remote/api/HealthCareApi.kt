package com.example.healthinfo.data.remote.api

import com.example.healthinfo.data.remote.body_request.*
import com.example.healthinfo.data.remote.dto.*
import com.example.healthinfo.data.remote.dto.answer_dto.AnswersListDto
import com.example.healthinfo.data.remote.dto.quesion_detatil_dto.QuestionDetailDto
import com.example.healthinfo.data.remote.dto.question_title_dto.QuestionsTitleDto
import retrofit2.http.*

interface HealthCareApi {

    companion object {
        const val BASE_URL = "http:10.0.2.2:4000/api/v1/"
    }

    @GET("question")
    suspend fun getQuestionTitle(): QuestionsTitleDto

    @POST("question")
    @Headers("Content-Type:application/json")
    suspend fun askQuestion(@Body requestBody: QuestionAskedBodyRequest): QuestionAskedDto

    @POST("answer")
    @Headers("Content-Type:application/json")
    suspend fun replayQuestion(@Body requestBody: ReplayQuestionBodyRequest): ReplayQuestionDto

    @POST("Login")
    @Headers("Content-Type:application/json")
    suspend fun login(@Body requestBody: UserEmailAndPassword): AuthLoginDto

    @POST("signup")
    @Headers("Content-Type:application/json")
    suspend fun signup(@Body requestBody: UserEmailAndPassword): SignUpDto

    @POST("more/doctor")
    @Headers("Content-Type:Application/json")
    suspend fun moreDoctor(@Body requestBody: DoctorBodyRequest): MoreDoctorDto

    @POST("more/user")
    @Headers("Content-Type:Application/json")
    suspend fun moreUser(@Body requestBody: UserBodyRequest): MoreUserDto

    @HTTP(method = "DELETE", path = "logout", hasBody = true)
    @Headers("Content-Type:Application/json")
    suspend fun logout(@Body requestBody: LogoutBodyRequest): LogoutDto

    @GET("question/{question_title}")
    suspend fun getQuestionDetail(@Path("question_title") paramBody: String): QuestionDetailDto

    @GET("answer/{question_title}")
    suspend fun getAnswersToQuestion(@Path("question_title") paramBody: String): AnswersListDto

    @GET("profile/{user_email}")
    suspend fun getDoctorProfile(@Path("user_email") paramBody: String): DoctorProfileDto

    @GET("profile/{user_email}")
    suspend fun getPatientProfile(@Path("user_email") paramBody: String): PatientProfileDto

    @POST("profile/{user_email}")
    suspend fun identifyUser(@Path("user_email") paramBody: String): IdentifyUserDto
    @POST("view")
    suspend fun addView(@Body requestBody: ViewBodyRequest ): ViewDto
    @POST("vote/add")
    suspend fun addVote(@Body requestBody: AddVoteRequestBody):AddVoteDto
    @POST("vote/remove")
    suspend fun removeVote(@Body requestBody: RemoveVoteRequestBody):RemoveVoteDto
}
