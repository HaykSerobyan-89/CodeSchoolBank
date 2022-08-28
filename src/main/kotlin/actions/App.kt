package actions

import models.address.Address
import models.bank.Bank
import models.cards.CreditCard
import models.cards.CreditCardEnum
import models.cards.allCards
import models.loan.Loan
import models.loan.LoanTypeEnum
import models.loan.LoanYearEnum
import models.loan.allLoans
import models.customer.Customer
import models.customer.allCustomers
import java.util.Scanner

class App {
    companion object App {
        private val scan = Scanner(System.`in`)
        private val bank = Bank("Ineco", Address("Yerevan", "Moskovyan", "33"))
        private val branch1 = bank.addNewBranch(Address("Yerevan", "Halabyan", "6/1"))


        fun start() {
            var run = true
            println(ActionEnum.WELCOME)
            println(ActionEnum.CHOOSE_BRANCH)
            while (run) {
                for (branch in Bank.branches) {
                    println(branch)
                }
                run = false
            }
        }
    }
}
