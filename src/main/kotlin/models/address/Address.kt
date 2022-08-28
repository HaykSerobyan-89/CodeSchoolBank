package models.address

data class Address(val city: String, val street: String, val building: String) {

    override fun toString(): String {
        return "Address: $city, $street street $building building"
    }
}