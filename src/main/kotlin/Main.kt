import app.App
import app.menu.ChooseBankMenu
import app.menu.MainMenu
import models.bank.Bank
import models.customer.Customer
import models.customer.identification.IdCard
import models.deposit.Deposit
import java.util.Date

fun main(args: Array<String>) {

    val me = Customer(IdCard("Hayk", "Serobyan", Date(1989, 8, 15),"123456", "123456"))
    println(me)
    println(Bank.branches)
    println(Bank.customers)
    App.start()

}