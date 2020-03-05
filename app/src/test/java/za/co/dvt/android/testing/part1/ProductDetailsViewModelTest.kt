package za.co.dvt.android.testing.part1

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import za.co.dvt.android.testing.part1.code.Product
import java.math.BigDecimal

class ProductDetailsViewModelTest {
    private lateinit var product: Product
    private lateinit var viewModel: ProductDetailsViewModel

    @Before
    fun setUp() {
        product = Product("", "", 0, BigDecimal.ZERO)
        viewModel = ProductDetailsViewModel(product)
    }

    @Test
    fun testGetFormattedCode_BlankInput_ReturnsUnknown() {
        product.code = "  "

        val actual = viewModel.getFormattedCode()

        assertEquals("unknown", actual)
    }

    @Test
    fun testGetFormattedCode_ShortInput_ReturnsSameProductCode() {
        product.code = "123"

        val actual = viewModel.getFormattedCode()

        assertEquals("123", actual)
    }

    @Test
    fun testGetFormattedCode_LongInput_ReturnsProductCodeFormattedWithSpaces() {
        product.code = "12345678"

        val actual = viewModel.getFormattedCode()

        assertEquals("123 456 78", actual)
    }

    @Test
    fun testGetFormattedName_ReturnsProductName() {
        product.name = "Beer"

        val actual = viewModel.getFormattedName()

        assertEquals("Beer", actual)
    }

    @Test
    fun testIsAvailableForPurchase_NegativeQuantity_ReturnsFalse() {
        product.quantity = -3

        val actual = viewModel.isAvailableForPurchase()

        assertFalse(actual)
    }

    @Test
    fun testIsAvailableForPurchase_ZeroQuantity_ReturnsFalse() {
        product.quantity = 0

        val actual = viewModel.isAvailableForPurchase()

        assertFalse(actual)
    }

    @Test
    fun testIsAvailableForPurchase_PositiveQuantity_ReturnsTrue() {
        product.quantity = 3

        val actual = viewModel.isAvailableForPurchase()

        assertTrue(actual)
    }

    @Test
    fun testGetMoreExpensiveProduct_OursHasHigherPrice_ReturnsOurProduct() {
        val other = Product("", "", 0, BigDecimal.ZERO)
        product.price = BigDecimal.TEN

        val actual = viewModel.getMoreExpensiveProduct(other)

        assertSame(product, actual)
    }

    @Test
    fun testGetMoreExpensiveProduct_SamePrices_ReturnsOurProduct() {
        val other = Product("", "", 0, BigDecimal.TEN)
        product.price = BigDecimal.TEN

        val actual = viewModel.getMoreExpensiveProduct(other)

        assertSame(product, actual)
    }

    @Test
    fun testGetMoreExpensiveProduct_OtherHasHigherPrice_ReturnsOtherProduct() {
        val other = Product("", "", 0, BigDecimal.TEN)
        product.price = BigDecimal.ZERO

        val actual = viewModel.getMoreExpensiveProduct(other)

        assertSame(other, actual)
    }
}
