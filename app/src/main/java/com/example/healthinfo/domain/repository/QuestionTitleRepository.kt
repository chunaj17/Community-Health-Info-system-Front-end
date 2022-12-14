package com.example.healthinfo.domain.repository

import com.example.healthinfo.core.Resource
import com.example.healthinfo.data.remote.body_request.*
import com.example.healthinfo.data.remote.dto.*
import com.example.healthinfo.data.remote.dto.question_title_dto.QuestionsTitleDto
import com.example.healthinfo.data.remote.dto.answer_dto.AnswersListDto
import com.example.healthinfo.data.remote.dto.quesion_detatil_dto.QuestionDetailDto
import kotlinx.coroutines.flow.Flow

interface QuestionTitleRepository {
    fun getQuestionsTitle():Flow<Resource<QuestionsTitleDto>>
    fun askQuestion(requestBody:QuestionAskedBodyRequest):Flow<Resource<QuestionAskedDto>>
    fun getQuestionDetail(requestParam:String):Flow<Resource<QuestionDetailDto>>
    fun getAnswerList(requestParam: String):Flow<Resource<AnswersListDto>>
    fun replayQuestion(requestBody:ReplayQuestionBodyRequest):Flow<Resource<ReplayQuestionDto>>
    fun addView(requestBody:ViewBodyRequest):Flow<Resource<ViewDto>>
    fun addVote(requestBody:AddVoteRequestBody):Flow<Resource<AddVoteDto>>
    fun removeVote(requestBody: RemoveVoteRequestBody):Flow<Resource<RemoveVoteDto>>
}