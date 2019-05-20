package indrivo.dentistbooking.api.validation

class ValidationRegExpPatterns {
    companion object {
        const val EMAIL = "^([A-Za-z0-9]+[A-Za-z0-9_.-]+[A-Za-z0-9]+)@([A-Za-z0-9]+[A-Za-z0-9-]+[A-Za-z0-9]+\\.)+([A-Za-z]+)\$"
        const val PATIENT_NAME = "^([A-Za-z]+[-]?[A-Za-z]+[ \\t]{0,})+\$"
        const val PHONE_NUMBER = "^[+]?\\d+\$"
    }
}
