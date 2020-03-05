package za.co.dvt.android.testing.part4.code

interface AccountManager {
    fun getFormattedAccountNumber(): String
    fun refresh()
    fun fetchTransaction(id: String)
    fun makePayment(to: Account, otp: Int)
}
