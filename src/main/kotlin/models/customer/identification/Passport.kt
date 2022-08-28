package models.customer.identification

import models.address.Address
import java.util.Date

class Passport(
    name: String,
    surname: String,
    birthDate: Date, address: Address
) : Document(name, surname, birthDate, address) {
}