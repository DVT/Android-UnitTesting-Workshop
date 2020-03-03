package za.co.dvt.android.testing.part1

import za.co.dvt.android.testing.part1.code.Product

/**
 * Part 1 - JUnit Basics
 * Get familiar with the basics of writing JUnit tests!
 */
class ProductDetailsViewModel(private val product: Product) {

    fun getFormattedCode(): String {
        if (product.code.isBlank()) {
            return "unknown"
        }
        return product.code.chunked(3)
                .joinToString(separator = " ")
    }

    fun getFormattedName(): String {
        return product.name
    }

    fun isAvailableForPurchase(): Boolean {
        return product.quantity > 0
    }

    fun getMoreExpensiveProduct(other: Product): Product {
        return if (product.price > other.price) product else other
    }
}
