package coffeemachinefinal.myenums

enum class CoffeeType(val coffeeName: String, val water: Int, val milk: Int, val coffeeBeans: Int, val cost: Int) {
    ESPRESSO("espresso", 250, 0, 16, 4),
    CAPPUCCINO("cappuccino", 200, 100, 12, 6),
    LATTE("latte", 350, 75, 20, 7);
}

/*

Remember, that:

For the espresso, the coffee machine needs 250 ml of water and 16 g of coffee beans. It costs $4.
For the latte, the coffee machine needs 350 ml of water, 75 ml of milk, and 20 g of coffee beans. It costs $7.
And for the cappuccino, the coffee machine needs 200 ml of water, 100 ml of milk, and 12 g of coffee. It costs $6.

*/