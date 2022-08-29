package app.menu

import models.address.Address
import models.bank.Bank
import models.customer.Customer
import models.customer.identification.Document
import models.customer.identification.IdCard
import models.customer.identification.Passport
import services.ServicesEnum
import java.util.*

class MainMenu {

    companion object MainMenu {
        private val scan = Scanner(System.`in`)
        var customer: Customer = identifyCustomer()

        private fun identifyCustomer(): Customer {
            println("Are you a bank customer ???")
            println("1. Yes")
            println("2. No")
            println("3. <--")
            when (scan.next().trim()) {
                "1" -> {
                    println("Please enter your Id card number or Passport serial number")
                    val data = scan.next()
                    if (Bank.customers[data] == null) {
                        println("Wrong input data !!!")
                        identifyCustomer()
                    } else {
                        try {
                            customer = Bank.customers[data]!!
                            println(customer)
                        } catch (e: NullPointerException) {
                            println(e)
                            identifyCustomer()
                        }
                    }
                }

                "2" -> {
                    customerRegister()
                }

                "3" -> {
                    ChooseBankMenu.show()
                }
            }
            return customer
        }

        private fun customerRegister() {
            println("Please provide your identification document for register")
            println("1. IdCard")
            println("2. Passport")
            println("3. <--")
            when (scan.next().trim()) {
                "1" -> {
                    val customer = Customer(dataEntry("IdCard"))
                    println(customer)
                }

                "2" -> {
                    val customer = Customer(dataEntry("Passport"))
                    println(customer)
                }

                "3" -> {
                    show()
                }
            }
        }

        private fun dataEntry(documentType: String): Document {
            print("Name: ")
            val name = scan.next()
            print("Surname: ")
            val surname = scan.next()
            print("Birthday year: ")
            val year = scan.next().toInt()
            print("Birthday month: ")
            val month = scan.next().toInt()
            print("Birthday day: ")
            val day = scan.next().toInt()
            if (documentType == "IdCard") {
                print("Id number: ")
                val numberID = scan.next()
                print("Social card numbers: ")
                val socialCardNumbers = scan.next()

                return IdCard(name, surname, Date(year, month, day), numberID, socialCardNumbers)

            } else {
                print("City: ")
                val city = scan.next()
                print("Street: ")
                val street = scan.next()
                print("Building / Apartment: ")
                val building = scan.next()
                print("Passport serial number: ")
                val serialNumber = scan.next()

                return Passport(name, surname, Date(year, month, day), Address(city, street, building), serialNumber)
            }
        }

        fun show() {

            for (service in ServicesEnum.values()) {
                println(service)
            }
            when (scan.next().trim()) {
                "1" -> {
                    CashMenu.show()
                }

                "2" -> {
                    println("DEPOSIT MENU")
                }

                "3" -> {
                    println("LOAN MENU")
                }

                "4" -> {
                    println("CARD MENU")
                }

                "5" -> System.out
                else -> show()

            }
        }
    }
}