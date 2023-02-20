package coffeemachinefinal.myenums

enum class Questions (val soru: String){
    ABOUT_ACTION("Write action (buy, fill, take, remaining, exit): "),
    ABOUT_BUY("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:  "),
    ABOUT_FILL_WATER("Write how many ml of water you want to add: "),
    ABOUT_FILL_MILK("Write how many ml of milk you want to add: "),
    ABOUT_FILL_COFFEE_BEANS("Write how many grams of coffee beans you want to add: "),
    ABOUT_FILL_DISPOSABLE_CUP("Write how many disposable cups you want to add: ")
}