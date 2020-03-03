package za.co.dvt.android.testing.part4

import za.co.dvt.android.testing.part4.code.Account
import za.co.dvt.android.testing.part4.code.AccountManager
import za.co.dvt.android.testing.part4.code.AccountManagerImpl

/**
 * Part 4 - Mocks
 * Learn about using mocks to minimize test code!
 */
class BankAccountDetailsViewModel(private val accountManager: AccountManager) {

    fun getFormattedAccountNumber(): String {
        return accountManager.getFormattedAccountNumber()
    }

    fun getAccountHolderName(): String {
        return accountManager.getAccountHolderName()
    }

    fun getFormattedAccountBalance(): String {
        return accountManager.getFormattedAccountBalance()
    }
}

/** Constructor-style factory method. */
@Suppress("FunctionName")
fun BankAccountDetailsViewModel(account: Account): BankAccountDetailsViewModel {
    return BankAccountDetailsViewModel(AccountManagerImpl(account))
}
