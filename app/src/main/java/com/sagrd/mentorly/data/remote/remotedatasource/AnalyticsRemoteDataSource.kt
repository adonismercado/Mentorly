package com.sagrd.mentorly.data.remote.remotedatasource

import com.sagrd.mentorly.data.remote.RemoteError
import com.sagrd.mentorly.data.remote.api.AnalyticsApi
import com.sagrd.mentorly.data.remote.dto.analytics.AnalyticsOverviewDto
import com.sagrd.mentorly.data.remote.dto.analytics.CompletionTimeReportDto
import com.sagrd.mentorly.data.remote.dto.analytics.DropOffDto
import com.sagrd.mentorly.data.remote.dto.analytics.EnrollmentHistoryDto
import com.sagrd.mentorly.data.remote.dto.analytics.PeerReviewBottleneckDto
import retrofit2.HttpException
import javax.inject.Inject

class AnalyticsRemoteDataSource @Inject constructor(
    private val api: AnalyticsApi
) {
    suspend fun getOverview(adminId: String): Result<AnalyticsOverviewDto> {
        return try {
            val response = api.getOverview(adminId)
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

    suspend fun getDropOff(adminId: String, courseId: String): Result<List<DropOffDto>> {
        return try {
            val response = api.getDropOff(adminId, courseId)
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

    suspend fun getCompletionTimeReport(adminId: String, courseId: String): Result<CompletionTimeReportDto> {
        return try {
            val response = api.getCompletionTimeReport(adminId, courseId)
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

    suspend fun getBottlenecks(adminId: String, courseId: String): Result<List<PeerReviewBottleneckDto>> {
        return try {
            val response = api.getBottlenecks(adminId, courseId)
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

    suspend fun getEnrollmentHistory(adminId: String, courseId: String): Result<List<EnrollmentHistoryDto>> {
        return try {
            val response = api.getEnrollmentHistory(adminId, courseId)
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