package models.user

import models.cards.CreditCard
import models.cards.CreditCardEnum
import models.loan.Loan
import models.loan.LoanTypeEnum

private var lastID: Int = 0
var allCustomers = HashMap<Int, Customer>()

class Customer(
    private val name: String,
    private val surname: String,
    var creditCards: MutableList<CreditCard> = mutableListOf(),
    var loans: MutableList<Loan> = mutableListOf()
) {
    private val id: Int = lastID + 1

    init {
        lastID += 1
        allCustomers[lastID] = this

    }

    fun getFullName(): String {
        return "$name $surname".toUpperCase()
    }

    fun takeNewCreditCard(cardType: CreditCardEnum): CreditCard {
        val newCreditCard = CreditCard(cardType, id)
        creditCards.add(newCreditCard)
        return newCreditCard
    }

    override fun toString(): String {
        return "Customer(id=$id, name='$name', surname='$surname', creditCards=$creditCards, loans=$loans)"
    }


}