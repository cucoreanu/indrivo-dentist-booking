package indrivo.dentistbooking.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Doctor(
        @Id
        @GeneratedValue
        var id: Long? = null,
        var name: String
)
