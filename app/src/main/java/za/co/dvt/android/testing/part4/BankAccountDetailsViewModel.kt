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

    fun onRetryClicked() {
        accountManager.refresh()
    }

    fun onTransactionClicked(transactionId: String) {
        accountManager.fetchTransaction(transactionId)
    }
}

/** Constructor-style factory method. */
@Suppress("FunctionName")
fun BankAccountDetailsViewModel(account: Account): BankAccountDetailsViewModel {
    return BankAccountDetailsViewModel(AccountManagerImpl(account))
}
