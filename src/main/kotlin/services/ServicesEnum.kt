package services

enum class ServicesEnum(private val id: Int, private val service: String) {
    CASH_IN_OUT(1, "Cash in/out"),
    DEPOSIT(2,"Deposit"),
    LOAN(3, "Loan"),
    CREDIT_CARD(4, "Credit card"),
    ALL_CUSTOMERS(5, "See all customers"),
    EXIT(6, "Exit the bank");


    override fun toString(): String {
        return "$id. $service"
    }


}