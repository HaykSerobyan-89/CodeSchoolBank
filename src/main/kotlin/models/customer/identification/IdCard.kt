package models.customer.identification

import java.util.Date
import kotlin.random.Random

class IdCard(
    name: String,
    surname: String,
    birthDate: Date,
    val numberID: String,
    val socialCardNumbers: String
) : Document(name, surname, birthDate) {


    override fun toString(): String {
        return "IdCard(name='$name', surname='$surname', " +
                "birthdate='${birthDate.date}/${birthDate.month}/${birthDate.year}', " +
                "$numberID='$numberID', socialCard='$socialCardNumbers')"
    }
}
