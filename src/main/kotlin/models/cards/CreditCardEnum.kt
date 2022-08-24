package models.cards

enum class CreditCardEnum(val id: Int, val type: String, val description: String) {
    VISA_CLASSIC(
        1,
        "VISA_CLASSIC",
        "Service fee: AMD 5,000 annually; " +
                "AMD 2,500 if ordered by Internet/Mobile Banking systems"
    ),
    MASTERCARD_STANDARD(
        2,
        "Mastercard Standard",
        "Service fee:AMD 5,000 annually; " +
                "AMD 2,500 if ordered by Internet/Mobile Banking systems"
    ),
    VISA_GOLD(
        3,
        "Visa Gold",
        "Service fee:AMD 2,000 monthly/ AMD 20,000 annually; " +
                "AMD 10,000 annually if ordered by Internet/Mobile Banking systems"
    ),
    MASTERCARD_GOLD(
        4,
        "Mastercard Gold",
        "Service fee: AMD 2,000 monthly/ AMD 20,000 annually; " +
                "AMD 10,000 annually if ordered by Internet/Mobile Banking systems"
    ),
    VISA_PLATINUM(
        5,
        "Visa Platinum",
        "Service fee: AMD 3,000 monthly/ AMD 30,000 annually; " +
                "AMD 20,000 annually if ordered by Internet/Mobile Banking systems"
    ),
    MASTERCARD_PLATINUM(
        6,
        "Mastercard Platinum",
        "Service fee: AMD 3,000 monthly/ AMD 30,000 annually; " +
                "AMD 20,000 annually if ordered by Internet/Mobile Banking systems"
    ),
    VISA_INFINITE(7, "Visa Infinite", "Service fee: AMD 10,000 monthly/ AMD 100,000 annually");

    override fun toString(): String {
        return type
    }
}
