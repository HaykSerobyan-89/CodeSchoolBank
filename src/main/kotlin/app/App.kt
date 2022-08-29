package app

import app.menu.ChooseBankMenu
import app.menu.MainMenu


class App {
    companion object App {

        fun start() {
            ChooseBankMenu.show()
            MainMenu.show()
        }
    }
}

