package za.co.dvt.android.testing.part3

import za.co.dvt.android.testing.part2.code.CoffeeCupSize
import za.co.dvt.android.testing.part2.code.CoffeeMachine
import za.co.dvt.android.testing.part2.code.CupOfCoffee
import za.co.dvt.android.testing.part2.code.ThermoplanCoffeeMachine

/**
 * Part 3 - Dependency Injection
 * Understand that "injecting" complex classes makes testing much easier!
 */
class StarbucksBarista(private val coffeeMachine: CoffeeMachine) {

    fun serveCoffee(size: CoffeeCupSize, description: String): CupOfCoffee {
        return coffeeMachine.makeCoffee(size, description)
    }
}

/** Constructor-style factory method. */
@Suppress("FunctionName")
fun StarbucksBarista(): StarbucksBarista {
    return StarbucksBarista(ThermoplanCoffeeMachine())
}
