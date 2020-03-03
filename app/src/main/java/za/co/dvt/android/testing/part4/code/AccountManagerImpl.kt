package za.co.dvt.android.testing.part4.code

import java.text.NumberFormat

class AccountManagerImpl(private val account: Account)
    : AccountManager {

    override fun getFormattedAccountNumber(): String {
        return account.number.chunked(4)
                .joinToString(separator = "-")
    }

    override fun getAccountHolderName(): String {
        return account.holderName
    }

    override fun getFormattedAccountBalance(): String {
        return NumberFormat.getCurrencyInstance().format(account.balance)
    }
}
