package models.loan

enum class LoanTypeEnum(val id: Int, val desc: String, val percent: Double) {

    MORTGAGE(1, "Հիփոթեքային վարկ", 6.0),
    AUTO_LOAN(2, "Ավտովարկ", 12.0),
    INSTALLMENT(3, "Ապառիկ", 18.0);

    override fun toString(): String {
        return "$id. $desc $percent % տարեկան"
    }

}