package za.co.dvt.android.testing.part2

import za.co.dvt.android.testing.part2.code.CoffeeCupSize
import za.co.dvt.android.testing.part2.code.CoffeeMachine
import za.co.dvt.android.testing.part2.code.CupOfCoffee
import za.co.dvt.android.testing.part2.code.ThermoplanCoffeeMachine

/**
 * Part 2 - Complex Dependencies
 * Learn how to test classes that depend on other classes!
 */
class StarbucksBarista {
    private val coffeeMachine: CoffeeMachine = ThermoplanCoffeeMachine()

    fun serveCoffee(size: CoffeeCupSize, description: String): CupOfCoffee {
        return coffeeMachine.makeCoffee(size, description)
    }
}
