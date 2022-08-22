package models.loan

import models.cards.CreditCard
import java.time.LocalDate

var allLoans = mutableListOf<Loan>()

class Loan(
    private val customerId: Int,
    private val amount: Long,
    private val loanType: LoanTypeEnum,
    private val loanYear: LoanYearEnum
) {
    var schedule = mutableListOf<Pair<LocalDate, Double>>()

    init {
        allLoans.add(this)
    }
    fun calculate(): MutableList<Pair<LocalDate, Double>> {
        val months = loanYear.months
        val totalAmount = amount * loanType.percent / 100 + amount

        println("--------------------------")
        println("Total amount: $totalAmount")
        println("Payment schedule")
        val monthlyPayment = totalAmount / 12
        for (i in 1..months) {
            schedule.add(Pair(LocalDate.now().plusMonths(i.toLong()), monthlyPayment))
        }
        allLoans.remove(this)

        return schedule
    }

    fun create() {}

    override fun toString(): String {
        return "Loan(amount=$amount, loanType=$loanType, customerId=$customerId, loanYear=$loanYear, schedule=$schedule)"
    }


}

