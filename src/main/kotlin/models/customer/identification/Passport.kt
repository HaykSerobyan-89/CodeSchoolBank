package models.customer.identification

import models.address.Address
import java.util.Date

class Passport(
    name: String,
    surname: String,
    birthDate: Date,
    private val address: Address,
    val serialNumber: String
) : Document(name, surname, birthDate) {

    override fun toString(): String {
        return "IdCard(name='$name', surname='$surname', " +
                "birthdate='${birthDate.date}/${birthDate.month}/${birthDate.year}', " +
                "address=$address, serialNumber='$serialNumber')"
    }
}