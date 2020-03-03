package za.co.dvt.android.testing.part4.code

import android.util.Log

class AccountManagerImpl(private val account: Account)
    : AccountManager {

    override fun refresh() {
        Log.i("AccountManagerImpl", "Refreshing $account")
    }

    override fun getFormattedAccountNumber(): String {
        return account.number.chunked(4)
                .joinToString(separator = "-")
    }

    override fun fetchTransaction(id: String) {
        Log.i("AccountManagerImpl", "Fetching transaction $id")
    }
}
