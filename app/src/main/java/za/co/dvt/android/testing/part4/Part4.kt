package za.co.dvt.android.testing.part4

import java.math.BigDecimal
import java.text.NumberFormat

/**
 * Part 4 - Mocks
 * Learn about using mocks to minimize test code!
 */
class Part4(private val accountManager: AccountManager) {

    fun getFormattedAccountNumber(): String {
        return accountManager.getFormattedAccountNumber()
    }

    fun getAccountHolderName(): String {
        return accountManager.getAccountHolderName()
    }

    fun getFormattedAccountBalance(): String {
        return accountManager.getFormattedAccountBalance()
    }

    companion object {

        fun newInstance(account: Account): Part4 {
            return Part4(AccountManagerImpl(account))
        }

    }

}

data class Account(
    var id: Int,
    var number: String,
    var holderName: String,
    var balance: BigDecimal
)

interface AccountManager {
    fun getFormattedAccountNumber(): String
    fun getAccountHolderName(): String
    fun getFormattedAccountBalance(): String
}

class AccountManagerImpl(private val account: Account) : AccountManager {

    override fun getFormattedAccountNumber(): String {
        val number = account.number
        val builder = StringBuilder()
        for (i in number.indices) {
            if (i % 4 == 0) {
                builder.append(' ')
            }
            builder.append(number[i])
        }
        return builder.toString().trim()
    }

    override fun getAccountHolderName(): String {
        return account.holderName
    }

    override fun getFormattedAccountBalance(): String {
        return NumberFormat.getCurrencyInstance().format(account.balance)
    }

}