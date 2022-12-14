package models.customer.identification

import models.address.Address
import java.util.Date

open class Document(
    val name: String,
    val surname: String,
    val birthDate: Date,
) {
    override fun toString(): String {
        return "Document(name='$name', surname='$surname', birthDate=$birthDate)"
    }
}