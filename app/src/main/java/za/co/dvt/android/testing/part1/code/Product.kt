package za.co.dvt.android.testing.part1.code

import java.math.BigDecimal

data class Product(
        val code: String,
        val name: String,
        val quantity: Int,
        val price: BigDecimal
)
