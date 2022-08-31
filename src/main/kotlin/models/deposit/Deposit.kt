package models.deposit

import models.customer.Customer


class Deposit {
    private var periodRate: HashMap<Int, Double> = hashMapOf(
        1 to 4.0, 2 to 4.0,
        3 to 6.0, 4 to 6.0, 5 to 6.0,
        6 to 8.5, 7 to 8.5, 8 to 8.5,
        9 to 9.0, 10 to 9.0, 11 to 9.0,
        12 to 9.5, 13 to 9.5, 14 to 9.5,
        15 to 10.0, 16 to 10.0, 17 to 10.0, 18 to 10.0, 19 to 10.0, 20 to 10.0, 21 to 10.0, 22 to 10.0, 23 to 10.0,
        24 to 10.5, 25 to 10.5, 26 to 10.5, 27 to 10.5, 28 to 10.5, 29 to 10.5, 30 to 10.5,
        31 to 11.0, 32 to 11.0, 33 to 11.0, 34 to 11.0, 35 to 11.0, 36 to 11.0
    )

    fun calculate(month: Int, amount: Long): Long {
        val monthRate : Double? = periodRate[month]?.div(12)
        var total = amount.toDouble()
        println(monthRate)

        if (month in 1..36) {
            if (monthRate != null) {
                for (i in 1..month) {
                    total += ((total * monthRate) / 100)
                    println(total)
                }
            }
        } else println("Please choose month from 1 until 36")

        return total.toLong()
    }
}