package com.sagrd.mentorly.data.remote.remotedatasource

import com.sagrd.mentorly.data.remote.RemoteError
import com.sagrd.mentorly.data.remote.api.SubmissionApi
import com.sagrd.mentorly.data.remote.dto.submission.AdminSubmissionDecisionDto
import com.sagrd.mentorly.data.remote.dto.submission.AdminEscalatedSubmissionDto
import com.sagrd.mentorly.data.remote.dto.submission.AdminSubmissionAuditDto
import com.sagrd.mentorly.data.remote.dto.submission.CreateSubmissionDto
import com.sagrd.mentorly.data.remote.dto.submission.SubmissionDto
import com.sagrd.mentorly.data.remote.dto.submission.SubmissionReviewDto
import com.sagrd.mentorly.data.remote.dto.submission.UpdateSubmissionDto
import retrofit2.HttpException
import javax.inject.Inject

class SubmissionRemoteDataSource @Inject constructor(
    private val api: SubmissionApi
) {

    suspend fun getEscalatedSubmissions(
        adminId: String
    ): Result<List<AdminEscalatedSubmissionDto>> {
        return try {
            val response = api.getEscalatedSubmissions(adminId)

            if (!response.isSuccessful) {
                Result.failure(RemoteError.REQUEST_FAILED.toException())
            } else {
                Result.success(response.body()!!)
            }
        } catch (exception: HttpException) {
            Result.failure(RemoteError.SERVER_ERROR.toException(exception))
        } catch (exception: Exception) {
            Result.failure(RemoteError.UNKNOWN_ERROR.toException(exception))
        }
    }

    suspend fun getEscalatedSubmissionAudit(
        adminId: String,
        submissionId: String
    ): Result<AdminSubmissionAuditDto> {
        return try {
            val response = api.getEscalatedSubmissionAudit(adminId, submissionId)

            if (!response.isSuccessful) {
                Result.failure(RemoteError.REQUEST_FAILED.toException())
            } else {
                Result.success(response.body()!!)
            }
        } catch (exception: HttpException) {
            Result.failure(RemoteError.SERVER_ERROR.toException(exception))
        } catch (exception: Exception) {
            Result.failure(RemoteError.UNKNOWN_ERROR.toException(exception))
        }
    }

    suspend fun createSubmission(
        enrollmentId: String,
        activityId: String,
        submission: CreateSubmissionDto
    ): Result<SubmissionDto> {
        return try {
            val response = api.createSubmission(enrollmentId, activityId, submission)

            if (!response.isSuccessful) {
                Result.failure(RemoteError.REQUEST_FAILED.toException())
            } else {
                Result.success(response.body()!!)
            }
        } catch (exception: HttpException) {
            Result.failure(RemoteError.SERVER_ERROR.toException(exception))
        } catch (exception: Exception) {
            Result.failure(RemoteError.UNKNOWN_ERROR.toException(exception))
        }
    }

    suspend fun updateSubmission(
        submissionId: String,
        submission: UpdateSubmissionDto
    ): Result<Unit> {
        return try {
            val response = api.updateSubmission(submissionId, submission)

            if (!response.isSuccessful) {
                Result.failure(RemoteError.REQUEST_FAILED.toException())
            } else {
                Result.success(response.body()!!)
            }
        } catch (exception: HttpException) {
            Result.failure(RemoteError.SERVER_ERROR.toException(exception))
        } catch (exception: Exception) {
            Result.failure(RemoteError.UNKNOWN_ERROR.toException(exception))
        }
    }

    suspend fun getSubmissionById(submissionId: String): Result<SubmissionDto> {
        return try {
            val response = api.getSubmissionById(submissionId)

            if (!response.isSuccessful) {
                Result.failure(RemoteError.REQUEST_FAILED.toException())
            } else {
                Result.success(response.body()!!)
            }
        } catch (exception: HttpException) {
            Result.failure(RemoteError.SERVER_ERROR.toException(exception))
        } catch (exception: Exception) {
            Result.failure(RemoteError.UNKNOWN_ERROR.toException(exception))
        }
    }

    suspend fun getSubmissionsByStudentId(
        studentId: String
    ): Result<List<SubmissionDto>> {
        return try {
            val response = api.getSubmissionsByStudentId(studentId)

            if (!response.isSuccessful) {
                Result.failure(RemoteError.REQUEST_FAILED.toException())
            } else {
                Result.success(response.body()!!)
            }
        } catch (exception: HttpException) {
            Result.failure(RemoteError.SERVER_ERROR.toException(exception))
        } catch (exception: Exception) {
            Result.failure(RemoteError.UNKNOWN_ERROR.toException(exception))
        }
    }

    suspend fun getSubmissionReviews(
        studentId: String,
        submissionId: String
    ): Result<List<SubmissionReviewDto>> {
        return try {
            val response = api.getSubmissionReviews(studentId, submissionId)

            if (!response.isSuccessful) {
                Result.failure(RemoteError.REQUEST_FAILED.toException())
            } else {
                Result.success(response.body()!!)
            }
        } catch (exception: HttpException) {
            Result.failure(RemoteError.SERVER_ERROR.toException(exception))
        } catch (exception: Exception) {
            Result.failure(RemoteError.UNKNOWN_ERROR.toException(exception))
        }
    }

    suspend fun escalateSubmission(
        studentId: String,
        submissionId: String
    ): Result<Unit> {
        return try {
            val response = api.escalateSubmission(studentId, submissionId)

            if (!response.isSuccessful) {
                Result.failure(RemoteError.REQUEST_FAILED.toException())
            } else {
                Result.success(response.body()!!)
            }
        } catch (exception: HttpException) {
            Result.failure(RemoteError.SERVER_ERROR.toException(exception))
        } catch (exception: Exception) {
            Result.failure(RemoteError.UNKNOWN_ERROR.toException(exception))
        }
    }

    suspend fun decideSubmission(
        adminId: String,
        submissionId: String,
        decision: AdminSubmissionDecisionDto
    ): Result<Unit> {
        return try {
            val response = api.decideSubmission(adminId, submissionId, decision)

            if (!response.isSuccessful) {
                Result.failure(RemoteError.REQUEST_FAILED.toException())
            } else {
                Result.success(response.body()!!)
            }
        } catch (exception: HttpException) {
            Result.failure(RemoteError.SERVER_ERROR.toException(exception))
        } catch (exception: Exception) {
            Result.failure(RemoteError.UNKNOWN_ERROR.toException(exception))
        }
    }
}