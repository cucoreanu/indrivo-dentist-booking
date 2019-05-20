package indrivo.dentistbooking.util

class ErrorResponse {
    companion object {
        val UNREADABLE_BODY = hashMapOf(Pair("errorMessage", "The request body cannot be read."))
    }
}
