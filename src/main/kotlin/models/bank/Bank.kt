package models.bank

import models.address.Address
import models.cards.CreditCard
import models.customer.Customer
import models.loan.Loan

private var bankID: Int = 1

class Bank(private val name: String, private val address: Address) {
    var id: Int = bankID

    init {
        bankID += 1
        Bank.branches.add(this)
    }

    companion object Bank {
        var branches = mutableListOf<models.bank.Bank>()
        var customers = mutableMapOf<Int, Customer>()
        var loans = HashMap<Int, List<Loan>>()
        var cards = HashMap<Int, List<CreditCard>>()
    }

    fun addNewBranch(address: Address): models.bank.Bank {
        return Bank(name, address)
    }

    override fun toString(): String {
        return "$id. $name Bank - $address"
    }

}