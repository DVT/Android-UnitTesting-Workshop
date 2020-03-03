package za.co.dvt.android.testing.part1.code

import java.math.BigDecimal

data class Product(
        var code: String,
        var name: String,
        var quantity: Int,
        var price: BigDecimal
)
