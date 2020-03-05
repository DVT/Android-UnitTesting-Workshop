package za.co.dvt.android.testing.part0

import org.junit.Assert.assertEquals
import org.junit.Test

class CalculatorTest {

    @Test
    fun testCalculateHalfOfSum() {
        val actual = Calculator().calculateHalfOfSum(2, 4)

        assertEquals(3, actual)
    }
}
