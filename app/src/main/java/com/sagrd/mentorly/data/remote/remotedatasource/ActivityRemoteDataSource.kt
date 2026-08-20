package com.sagrd.mentorly.data.remote.remotedatasource

import com.sagrd.mentorly.data.remote.RemoteError
import com.sagrd.mentorly.data.remote.api.ActivityApi
import com.sagrd.mentorly.data.remote.dto.activity.CreateActivityDto
import com.sagrd.mentorly.data.remote.dto.activity.UpdateActivityDto
import com.sagrd.mentorly.data.remote.dto.common.ReorderItemsDto
import com.sagrd.mentorly.data.remote.dto.content.ActivityDto
import retrofit2.HttpException
import javax.inject.Inject

class ActivityRemoteDataSource @Inject constructor(
    private val api: ActivityApi
) {

    suspend fun getActivities(themeId: String): Result<List<ActivityDto>> {
        return try {
            val response = api.getActivities(themeId)

            if (!response.isSuccessful) {
                Result.failure(RemoteError.REQUEST_FAILED.toException())
            } else {
                Result.success(response.body()!!)
            }
        } catch (exception: HttpException) {
            Result.failure(Exception(RemoteError.SERVER_ERROR.toException(exception)))
        } catch (exception: Exception) {
            Result.failure(Exception(RemoteError.UNKNOWN_ERROR.toException(exception)))
        }
    }

    suspend fun createActivity(
        adminId: String,
        themeId: String,
        activity: CreateActivityDto
    ): Result<ActivityDto> {
        return try {
            val response = api.createActivity(adminId, themeId, activity)

            if (!response.isSuccessful) {
                Result.failure(RemoteError.REQUEST_FAILED.toException())
            } else {
                Result.success(response.body()!!)
            }
        } catch (exception: HttpException) {
            Result.failure(Exception(RemoteError.SERVER_ERROR.toException(exception)))
        } catch (exception: Exception) {
            Result.failure(Exception(RemoteError.UNKNOWN_ERROR.toException(exception)))
        }
    }

    suspend fun updateActivity(
        adminId: String,
        activityId: String,
        activity: UpdateActivityDto
    ): Result<Unit> {
        return try {
            val response = api.updateActivity(adminId, activityId, activity)

            if (!response.isSuccessful) {
                Result.failure(RemoteError.REQUEST_FAILED.toException())
            } else {
                Result.success(Unit)
            }
        } catch (exception: HttpException) {
            Result.failure(Exception(RemoteError.SERVER_ERROR.toException(exception)))
        } catch (exception: Exception) {
            Result.failure(Exception(RemoteError.UNKNOWN_ERROR.toException(exception)))
        }
    }

    suspend fun deleteActivity(
        adminId: String,
        activityId: String
    ): Result<Unit> {
        return try {
            val response = api.deleteActivity(adminId, activityId)

            if (!response.isSuccessful) {
                Result.failure(RemoteError.REQUEST_FAILED.toException())
            } else {
                Result.success(Unit)
            }
        } catch (exception: HttpException) {
            Result.failure(Exception(RemoteError.SERVER_ERROR.toException(exception)))
        } catch (exception: Exception) {
            Result.failure(Exception(RemoteError.UNKNOWN_ERROR.toException(exception)))
        }
    }

    suspend fun reorderActivities(
        adminId: String,
        themeId: String,
        items: ReorderItemsDto
    ): Result<Unit> {
        return try {
            val response = api.reorderActivities(adminId, themeId, items)

            if (!response.isSuccessful) {
                Result.failure(RemoteError.REQUEST_FAILED.toException())
            } else {
                Result.success(Unit)
            }
        } catch (exception: HttpException) {
            Result.failure(Exception(RemoteError.SERVER_ERROR.toException(exception)))
        } catch (exception: Exception) {
            Result.failure(Exception(RemoteError.UNKNOWN_ERROR.toException(exception)))
        }
    }
}