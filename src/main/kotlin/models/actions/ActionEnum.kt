package models.actions

enum class ActionEnum(val id: Int, val description: String) {
    REGISTER(1, "Register customer"),
    SHOW_ALL_CUSTOMERS(2, "Show all customers"),
    TAKE_CARD(3,"Take credit card"),
    SHOW_ALL_CARDS(4,"Show all cards"),
    SHOW_CARDS(5, "Show my all cards"),
    CALCULATE_LOAN(6, "Calculate and show loan payment schedule"),
    SHOW_ALL_LOANS(7, "Show all loans"),
    EXIT(8, "Exit the app");
}