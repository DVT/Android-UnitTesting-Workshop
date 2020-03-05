package za.co.dvt.android.testing.part2

import org.junit.Assert.assertEquals
import org.junit.Assert.assertSame
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import za.co.dvt.android.testing.part2.code.CoffeeCupSize

class StarbucksBaristaTest {
    private lateinit var starbucksBarista: StarbucksBarista

    @Before
    fun setUp() {
        starbucksBarista = StarbucksBarista()
    }

    @Test
    @Ignore("Tests like this are fragile and should be avoided")
    fun testServeCoffee_ReturnsTastyCupOfCoffee() {
        val actual = starbucksBarista.serveCoffee(CoffeeCupSize.GRANDE, "cappuccino")

        assertSame(CoffeeCupSize.GRANDE, actual.size)
        assertEquals("cappuccino", actual.description)
        assertEquals(System.nanoTime(), actual.timeCompleted)
    }
}
