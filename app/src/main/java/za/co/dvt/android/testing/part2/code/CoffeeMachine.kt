package za.co.dvt.android.testing.part2.code

interface CoffeeMachine {
    fun makeCoffee(size: CoffeeCupSize, description: String): CupOfCoffee
}
