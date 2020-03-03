package za.co.dvt.android.testing.part4.code

import java.math.BigDecimal

data class Account(
        var id: Int,
        var number: String,
        var holderName: String,
        var balance: BigDecimal
)
