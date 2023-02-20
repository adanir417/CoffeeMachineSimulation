package coffeemachinefinal

import coffeemachinefinal.myenums.CoffeeType
import coffeemachinefinal.myenums.MyText
import coffeemachinefinal.myenums.Questions
import coffeemachinefinal.myenums.Status


class CoffeeBackStage(
    var machineMoney: Int = 550,
    var machineWater: Int = 400,
    var machineMilk: Int = 540,
    var machineCoffeeBeans: Int = 120,
    var machineDisposableCup: Int = 9,
    var tekrarSayisi: Int = 0,
    var actionSet: String = ""

) {

    fun startFromHere() {
        while (tekrarSayisi == 0) {
            println(Questions.ABOUT_ACTION.soru)
            actionSet = readln().lowercase()


            when (actionSet) {
                Status.BUY.durum -> {
                    buy()
                }

                Status.FILL.durum -> {
                    fill()
                }

                Status.TAKE.durum -> {
                    take()
                }

                Status.REMAINING.durum -> {
                    statusUpdate()
                }

                Status.EXIT.durum -> {
                    tekrarSayisi = 1
                }

            }
        }
    }


    private fun buy() {
        println(Questions.ABOUT_BUY.soru)
        val buyChoice = readln().toString()
        when (buyChoice) {
            "1" -> {
                if (calculateIngredients(CoffeeType.ESPRESSO)) {
                    coffeeProcess(CoffeeType.ESPRESSO)
                }
            }

            "2" -> {
                if (calculateIngredients(CoffeeType.LATTE)) {
                    coffeeProcess(CoffeeType.LATTE)
                }
            }

            "3" -> {
                if (calculateIngredients(CoffeeType.CAPPUCCINO)) {
                    coffeeProcess(CoffeeType.CAPPUCCINO)
                }
            }

            Status.BACK.durum -> {
                startFromHere()
            }

        }
    }


    private fun calculateIngredients(coffeeType: CoffeeType): Boolean {
        var waterBool: Boolean = false
        var milkBool: Boolean = false
        var coffeeBool: Boolean = false
        var disposableCupBool: Boolean = false

        if (coffeeType.water != 0) {
            if (machineWater / coffeeType.water > 0) {
                waterBool = true
            } else {
                println(MyText.SORRY_NOT_ENOUGH_WATER.mesaj)
            }
        }

        if (coffeeType.milk != 0) {
            if (machineMilk / coffeeType.milk > 0) {
                milkBool = true
            } else {
                println(MyText.SORRY_NOT_ENOUGH_MILK.mesaj)
            }
        }

        if (coffeeType.coffeeBeans != 0) {
            if (machineCoffeeBeans / coffeeType.coffeeBeans > 0) {
                coffeeBool = true
            } else {
                println(MyText.SORRY_NOT_ENOUGH_COFFEE_BEANS.mesaj)
            }
        }

        if (machineDisposableCup - 1 >= 0) {
            disposableCupBool = true
        } else {
            println(MyText.SORRY_NOT_ENOUGH_DISPOSABLE_CUP.mesaj)
        }

        return when (coffeeType) {
            CoffeeType.ESPRESSO -> {
                waterBool && coffeeBool && disposableCupBool
            }

            CoffeeType.CAPPUCCINO -> {
                waterBool && milkBool && coffeeBool && disposableCupBool
            }

            CoffeeType.LATTE -> {
                waterBool && milkBool && coffeeBool && disposableCupBool
            }
        }


    }

    private fun coffeeProcess(coffeeType: CoffeeType) {
        println(MyText.ENOUGH_RESOURCES.mesaj)
        machineWater -= coffeeType.water
        machineMilk -= coffeeType.milk
        machineCoffeeBeans -= coffeeType.coffeeBeans
        machineMoney += coffeeType.cost
        machineDisposableCup--

    }

    private fun statusUpdate() {
        println(MyText.MACHINE_HAS.mesaj)
        println("${machineWater} ${MyText.MACHINE_HAS_Ml_OF_WATER.mesaj}")
        println("${machineMilk} ${MyText.MACHINE_HAS_Ml_OF_MILK.mesaj}")
        println("${machineCoffeeBeans} ${MyText.MACHINE_HAS_Ml_OF_COFFEE_BEANS.mesaj}")
        println("$machineDisposableCup ${MyText.MACHINE_HAS_Ml_OF_DISPOSABLE_CUP.mesaj}")
        println("${MyText.DOLLAR_SIGN.mesaj}${machineMoney} ${MyText.MACHINE_HAS_NUMBER_OF_MONEY.mesaj}")
        println()
    }

    private fun fill() {
        println(Questions.ABOUT_FILL_WATER.soru)
        machineWater += readln().toInt()
        println(Questions.ABOUT_FILL_MILK.soru)
        machineMilk += readln().toInt()
        println(Questions.ABOUT_FILL_COFFEE_BEANS.soru)
        machineCoffeeBeans += readln().toInt()
        println(Questions.ABOUT_FILL_DISPOSABLE_CUP.soru)
        machineDisposableCup += readln().toInt()
        println()
    }

    private fun take() {
        print("${MyText.I_GAVE_YOU.mesaj} ${MyText.DOLLAR_SIGN.mesaj}${machineMoney}")
        machineMoney = 0
        println()
    }


}