package models.loan

enum class LoanYearEnum(val id: Int, val description: String, val months: Int) {
    ONE_YEAR(1, "One year", 12),
    TWO_YEAR(2, "Two year", 24),
    THREE_YEAR(3, "Three year", 36),
    FOUR_YEAR(4, "Four year", 48),
    FIVE_YEAR(5, "Five year", 60);

    override fun toString(): String {
        return "$id. $description -> $months months "
    }


}
