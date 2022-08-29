package app.menu

import models.address.Address
import models.bank.Bank
import models.customer.Customer
import models.customer.identification.Document
import models.customer.identification.IdCard
import models.customer.identification.Passport
import java.util.*

class CashMenu {

    companion object CashMenuMenu {
        private val scan = Scanner(System.`in`)



        fun show() {
            println("1. Cash in")
            println("2. Cash out")
            println("3. See your info")
            println("4. <--")
            when (scan.next().trim()) {
                "1" -> {
                    println("How much money do you want to deposit into your account?")
                    print("The amount of money: ")
                    val money = scan.nextLong()
                    MainMenu.customer.balance += money
                    println("Your account balance ${MainMenu.customer.balance}")
                    println("Transaction completed successfully !!!")
                    show()
                }

                "2" -> {
                    println("How much money do you want to withdraw from your account?")
                    print("The amount of money: ")
                    val money = scan.nextLong()
                    if (money <= MainMenu.customer.balance) {
                        MainMenu.customer.balance -= money
                        println("Your account balance ${MainMenu.customer.balance}")
                        println("Transaction completed successfully !!!")
                        show()
                    } else {
                        println("Your account balance is insufficient to complete this transaction")
                        show()
                    }
                }

                "3" -> {
                    println(MainMenu.customer)
                    show()
                }

                "4" -> {
                    MainMenu.show()
                }
            }
        }
    }
}