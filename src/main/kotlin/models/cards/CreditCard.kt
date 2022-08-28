package models.cards

import models.customer.allCustomers
import java.time.LocalDate
import kotlin.random.Random

private var cardId = 0
var allCards = mutableListOf<CreditCard>()

class CreditCard(private val cardType: CreditCardEnum, private val customerId: Int) {
    private var id = cardId + 1
    var balance: Long = 0
    var cardAccountNumber: String = ""
    private val customerFullName = allCustomers[customerId]?.getFullName()
    private var validDate: String = ""
    private var cvv: Int = 0


    init {
        cardId += 1
        validDate = validDateStr(generateValidDate())
        cardAccountNumber = generateCardAccountNumber()
        cvv = generateCVV()
        allCards.add(this)
        allCustomers[customerId]?.creditCards?.add(this)

    }

    private fun generateValidDate(year: Int = 5): LocalDate {
        return LocalDate.now().plusMonths(((year * 12).toLong()))
    }

    private fun validDateStr(date: LocalDate): String {
        val dateList = date.toString().split("-")
        return dateList[1] + "/" + dateList[0].substring(startIndex = 2)
    }

    private fun generateCVV(): Int {
        var multiplier = 1
        for (i in 1..3) {
            cvv += multiplier * Random.nextInt(from = 0, until = 9)
            multiplier *= 10
        }
        return cvv
    }

    private fun generateCardAccountNumber(): String {
        for (i in 0 until 16) {
            if (i % 4 == 0 && i != 0) cardAccountNumber += " "
            cardAccountNumber += (Random.nextInt(from = 0, until = 9)).toString()
        }
        return cardAccountNumber
    }

    override fun toString(): String {
        return "CreditCard(cardId=$id, cardType='$cardType', balance=$balance AMD, customer='$customerFullName', " +
                "validDate='$validDate', cardAccountNumber='$cardAccountNumber', cvv=$cvv)"
    }


}