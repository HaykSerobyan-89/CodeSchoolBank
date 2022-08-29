package app.menu

import models.address.Address
import models.bank.Bank
import java.util.Scanner

class ChooseBankMenu {
    companion object ChooseBankMenu {
        var bank: Bank? = null
        private val scan = Scanner(System.`in`)
        private val branchMain = Bank("Armenia", Address("Yerevan", "Moskovyan", "55"))
        val branchSecond = branchMain.addNewBranch(Address("Yerevan", "Halabyan", "6/1"))


        fun show() {
            println("Hello, ${branchMain.name} bank welcomes you.")
            println("Please choose which branch you want to be served at")
            for (bank in Bank.branches.values) {
                println(bank)
            }
            when (scan.next().trim()) {
                "1" -> {
                    bank = Bank.branches[1]
                }

                "2" -> {
                    bank = Bank.branches[2]
                }

                else -> {
                    println("Please enter bank branch correctly")
                    show()
                }
            }
        }
    }
}