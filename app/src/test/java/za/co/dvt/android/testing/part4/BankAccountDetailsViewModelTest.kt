package za.co.dvt.android.testing.part4

import com.nhaarman.mockitokotlin2.*
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations.initMocks
import za.co.dvt.android.testing.part4.code.Account
import za.co.dvt.android.testing.part4.code.AccountManager
import java.math.BigDecimal

class BankAccountDetailsViewModelTest {
    @Mock
    private lateinit var accountManager: AccountManager
    private lateinit var viewModel: BankAccountDetailsViewModel

    @Before
    fun setUp() {
        initMocks(this)
        viewModel = BankAccountDetailsViewModel(accountManager)
    }

    @Test
    fun testGetFormattedAccountNumber() {
        whenever(accountManager.getFormattedAccountNumber()).thenReturn("Hello world")

        val actual = viewModel.getFormattedAccountNumber()

        assertEquals("Hello world", actual)
    }

    @Test
    fun testRefresh() {
        viewModel.onRetryClicked()

        verify(accountManager).refresh()
    }

    @Test
    fun testOnTransactionClicked() {
        viewModel.onTransactionClicked("123")

        verify(accountManager).fetchTransaction("123")
    }

    @Test
    fun testOnPayClicked_ValidOtp_DelegatesToAccountManager() {
        val toAccount = Account(123, "123-456", "PJ", BigDecimal(1_000_000))

        viewModel.onPayClicked(toAccount, 4321)

        val captor = argumentCaptor<Account>()
        verify(accountManager).makePayment(captor.capture(), eq(4321))
        captor.firstValue.let {
            assertEquals(123, it.id)
            assertEquals("123-456", it.number)
            assertEquals("PJ", it.holderName)
            assertEquals(0, it.balance.compareTo(BigDecimal(1_000_000)))
        }
    }

    @Test
    fun testOnPayClicked_InvalidOtp_DoesNotDelegateToAccountManager() {
        val toAccount = Account(123, "123-456", "PJ", BigDecimal(1_000_000))

        viewModel.onPayClicked(toAccount, 9999)

        verify(accountManager, never()).makePayment(any(), any())
    }
}
