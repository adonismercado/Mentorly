package com.sagrd.mentorly.data.remote

enum class RemoteError(val message: String) {
    REQUEST_FAILED("No se pudo completar la solicitud. Intenta de nuevo más tarde."),
    SERVER_ERROR("Ocurrió un problema al comunicarnos con el servidor. Intenta más tarde."),
    UNKNOWN_ERROR("Algo salió mal. Intenta de nuevo más tarde.");

    fun toException(cause: Throwable? = null): Exception = Exception(message, cause)
}