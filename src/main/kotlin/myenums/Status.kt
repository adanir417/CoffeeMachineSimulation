package coffeemachinefinal.myenums

enum class Status(val durum: String) {
    BUY("buy"),
    FILL("fill"),
    TAKE("take"),
    REMAINING("remaining"),
    EXIT("exit"),
    BACK("back")
}