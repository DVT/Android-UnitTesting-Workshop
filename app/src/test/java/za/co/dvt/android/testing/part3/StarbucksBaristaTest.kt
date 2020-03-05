package za.co.dvt.android.testing.part3

import org.junit.Assert.assertSame
import org.junit.Before
import org.junit.Test
import za.co.dvt.android.testing.part2.code.CoffeeCupSize
import za.co.dvt.android.testing.part2.code.CoffeeMachine
import za.co.dvt.android.testing.part2.code.CupOfCoffee

class StarbucksBaristaTest {
    private lateinit var coffeeMachine: TestCoffeeMachine
    private lateinit var starbucksBarista: StarbucksBarista

    @Before
    fun setUp() {
        coffeeMachine = TestCoffeeMachine()
        starbucksBarista = StarbucksBarista(coffeeMachine)
    }

    @Test
    fun testServeCoffee() {
        val cupOfCoffee = CupOfCoffee(CoffeeCupSize.SHORT, "black", 0)
        coffeeMachine.cupOfCoffee = cupOfCoffee

        val actual = starbucksBarista.serveCoffee(CoffeeCupSize.SHORT, "black")

        assertSame(cupOfCoffee, actual)
    }

    private class TestCoffeeMachine : CoffeeMachine {
        lateinit var cupOfCoffee: CupOfCoffee

        override fun makeCoffee(size: CoffeeCupSize, description: String): CupOfCoffee {
            return cupOfCoffee
        }
    }
}
