package com.sagrd.mentorly.data.remote.remotedatasource

import com.sagrd.mentorly.data.remote.RemoteError
import com.sagrd.mentorly.data.remote.api.CourseCommunityApi
import com.sagrd.mentorly.data.remote.dto.community.CourseMemberDto
import com.sagrd.mentorly.data.remote.dto.community.LeaderboardEntryDto
import retrofit2.HttpException
import javax.inject.Inject

class CourseCommunityRemoteDataSource @Inject constructor(
    private val api: CourseCommunityApi
) {

    suspend fun getCourseMembers(
        courseId: String,
        viewerStudentId: String
    ): Result<List<CourseMemberDto>> {
        return try {
            val response = api.getCourseMembers(courseId, viewerStudentId)

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

    suspend fun getLeaderboard(
        courseId: String,
        viewerStudentId: String
    ): Result<List<LeaderboardEntryDto>> {
        return try {
            val response = api.getLeaderboard(courseId, viewerStudentId)

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

    suspend fun getLeaderboardEntry(
        courseId: String,
        studentId: String
    ): Result<LeaderboardEntryDto> {
        return try {
            val response = api.getLeaderboardEntry(courseId, studentId)

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

    suspend fun getAdminLeaderboard(
        adminId: String,
        courseId: String
    ): Result<List<LeaderboardEntryDto>> {
        return try {
            val response = api.getAdminLeaderboard(adminId, courseId)

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