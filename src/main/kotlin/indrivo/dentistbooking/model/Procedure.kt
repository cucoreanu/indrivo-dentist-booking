package indrivo.dentistbooking.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Procedure(
        @Id
        @GeneratedValue
        var id: Long? = null,
        var name: String,
        var duration: Int
)
