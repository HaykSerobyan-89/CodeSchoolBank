package models.actions

import models.cards.CreditCard
import models.cards.CreditCardEnum
import models.cards.allCards
import models.loan.Loan
import models.loan.LoanTypeEnum
import models.loan.LoanYearEnum
import models.loan.allLoans
import models.user.Customer
import models.user.allCustomers
import java.util.Scanner

class App {
    companion object App {
        private val scan = Scanner(System.`in`)

        private fun cardTypeConfirmMenu(cardType: CreditCardEnum) {
            println("1. Confirm")
            println("2. Go back to credit types")
            when (scan.next()) {
                "1" -> {
                    println("Please enter customer id to create card for him/her")
                    val customerId = scan.nextInt()
                    println(allCustomers.size)
                    if (allCustomers.size == 0) {
                        println("Please register a customer and then create credit card")
                    } else if (allCustomers[customerId] == null) {
                        println("Please enter correct id of customer")
                    } else {
                        val card = allCustomers[customerId]?.let { CreditCard(cardType, customerId) }
                        println("Congratulations you have a new card")
                        println(card)
                    }
                }

                "2" -> chooseCardType()
                else -> {
                    println("Please correctly enter the number of action !!!")
                }
            }
        }

        private fun chooseCardType() {
            println("What type of card do you want?")
            println("Choose card type from list to see description")
            for (card in CreditCardEnum.values())
                println("${card.id}. ${card.type}")
            when (scan.next()) {
                "1" -> {
                    println(
                        "${CreditCardEnum.VISA_CLASSIC.type}: " +
                                CreditCardEnum.VISA_CLASSIC.description
                    )
                    cardTypeConfirmMenu(CreditCardEnum.VISA_CLASSIC)
                }

                "2" -> {
                    println(
                        "${CreditCardEnum.MASTERCARD_STANDARD.type}: " +
                                CreditCardEnum.MASTERCARD_STANDARD.description
                    )
                    cardTypeConfirmMenu(CreditCardEnum.MASTERCARD_STANDARD)
                }

                "3" -> {
                    println(
                        "${CreditCardEnum.VISA_GOLD.type}: " +
                                CreditCardEnum.VISA_GOLD.description
                    )
                    cardTypeConfirmMenu(CreditCardEnum.VISA_GOLD)
                }

                "4" -> {
                    println(
                        "${CreditCardEnum.MASTERCARD_GOLD.type}: " +
                                CreditCardEnum.MASTERCARD_GOLD.description
                    )
                    cardTypeConfirmMenu(CreditCardEnum.MASTERCARD_GOLD)
                }

                "5" -> {
                    println(
                        "${CreditCardEnum.VISA_PLATINUM.type}: " +
                                CreditCardEnum.VISA_PLATINUM.description
                    )
                    cardTypeConfirmMenu(CreditCardEnum.VISA_PLATINUM)
                }

                "6" -> {
                    println(
                        "${CreditCardEnum.MASTERCARD_PLATINUM.type}: " +
                                CreditCardEnum.MASTERCARD_PLATINUM.description
                    )
                    cardTypeConfirmMenu(CreditCardEnum.MASTERCARD_PLATINUM)
                }

                "7" -> {
                    println(
                        "${CreditCardEnum.VISA_INFINITE.type}: " +
                                CreditCardEnum.VISA_INFINITE.description
                    )
                    cardTypeConfirmMenu(CreditCardEnum.VISA_INFINITE)
                }

                else -> {
                    println("Please correctly enter the number of action !!!")
                    chooseCardType()
                }
            }
        }

        fun start() {
            var run = true
            println("Please correctly choose action by number ! ! !")
            while (run) {
                println("--------------------------------")
                for (action in ActionEnum.values()) {
                    println("${action.id}. ${action.description}")
                }
                when (scan.next()) {
                    "1" -> {
                        println("Enter your name: ")
                        val name = scan.next().trim()
                        println("Enter your surname: ")
                        val surname = scan.next().trim()
                        val customer = Customer(name, surname)
                        println("You are registered successfully. Your data is")
                        println(customer)
                    }

                    "2" -> {
                        println("All customers of the bank")
                        if (allCustomers.size == 0) {
                            println("The bank does not have a client yet !!!")
                        } else {
                            var count = 1
                            for (customer in allCustomers.values) {
                                print("$count. $customer")
                                count += 1
                            }
                        }
                    }

                    "3" -> chooseCardType()


                    "4" -> {
                        if (allCards.size == 0) {
                            println("The bank does not have a credit card yet !!!")
                        } else {
                            for (card in allCards) {
                                println(card)
                            }
                        }
                    }

                    "5" -> {
                        println("Please enter your id to see your cards")
                        val customerId = scan.nextInt()
                        val customerAllCards = allCustomers[customerId]?.creditCards
                        if (customerAllCards != null) {
                            for (card in customerAllCards) {
                                println(card)
                            }
                        }
                    }

                    "6" -> {
                        println("Please choose the loan type to calculate it: ")
                        for (loan in LoanTypeEnum.values()) {
                            println(loan)
                        }
                        val loanType = when (scan.nextInt()) {
                            1 -> LoanTypeEnum.MORTGAGE
                            2 -> LoanTypeEnum.AUTO_LOAN
                            3 -> LoanTypeEnum.INSTALLMENT
                            else -> scan.nextInt()
                        }
                        print("Please enter money amount: ")
                        val amount = scan.nextLong()
                        for (year in LoanYearEnum.values()) {
                            println(year)
                        }
                        print("Select the term of the loan: ")
                        val year = when (scan.nextInt()) {
                            1 -> LoanYearEnum.ONE_YEAR
                            2 -> LoanYearEnum.TWO_YEAR
                            3 -> LoanYearEnum.THREE_YEAR
                            4 -> LoanYearEnum.FOUR_YEAR
                            5 -> LoanYearEnum.FIVE_YEAR
                            else -> scan.nextInt()
                        }

                        val loan = Loan(1, amount, loanType as LoanTypeEnum, year as LoanYearEnum)
                        var count = 1
                        for ((date, paymentAmount) in loan.calculate()) {
                            println("$count. $date $paymentAmount")
                            count += 1
                        }
                    }

                    "7" -> {
                        if (allLoans.size == 0) {
                            println("The bank does not have a loans yet !!!")
                        } else {
                            for (loan in allLoans) {
                                println(loan)
                            }
                        }
                    }

                    "8" -> run = false
                    else -> {
                        println("Please correctly enter the number of action !!!")
                    }
                }
            }
        }
    }
}
