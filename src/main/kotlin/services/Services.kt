package services

enum class ServicesEnum(private val id: Int,private val service: String) {
    CASH_IN_OUT(1, "Cash in/out"),
    TRANSFERS(2, "Transfers"),
    DEPOSIT(3,"Deposit"),
    LOAN(4, "Loan"),
    ACCOUNT_CARD(5, "Account/card"),
    LEGAL_ENTITIES(6, "Legal entities");

    override fun toString(): String {
        return "$id. $service"
    }


}