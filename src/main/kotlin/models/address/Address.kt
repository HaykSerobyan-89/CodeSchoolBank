package models.address

data class Address(val city: String, val street: String, val building: String) {

    override fun toString(): String {
        return "'$city, $street street $building building'"
    }
}