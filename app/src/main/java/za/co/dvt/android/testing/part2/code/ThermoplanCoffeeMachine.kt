package za.co.dvt.android.testing.part2.code

class ThermoplanCoffeeMachine : CoffeeMachine {

    override fun makeCoffee(size: CoffeeCupSize, description: String): CupOfCoffee {
        return CupOfCoffee(size, description)
    }
}
