package actions

import models.bank.Bank

enum class ActionEnum(private val text: String) {
    WELCOME("Hello, Our bank welcomes you."),
    CHOOSE_BRANCH("Please choose which branch you want to be served at");

    override fun toString(): String {
        return "$text"
    }
}