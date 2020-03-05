package za.co.dvt.android.testing.part6

import android.os.Bundle
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.spy
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [28])
class UserProfileViewModelTest {
    private lateinit var viewModel: UserProfileViewModel

    @Before
    fun setUp() {
        viewModel = UserProfileViewModel()
    }

    @Test(expected = IllegalArgumentException::class)
    fun testInitialise_NullArgs_ThrowsException() {
        viewModel.initialise(null)
    }

    @Test
    fun testInitialise_NonNullArgs_SetsFields() {
        val args = mock<Bundle>().apply {
            whenever(getString("user_name")).thenReturn("Name")
            whenever(getString("email_address")).thenReturn("test@addr.com")
        }

        viewModel.initialise(args)

        assertEquals("Name", viewModel.userName.get())
        assertEquals("test@addr.com", viewModel.emailAddress.get())
    }

    @Test
    fun testGetEditScreenIntent_ReturnsIntentWithCorrectAction() {
        val actual = viewModel.getEditScreenIntent()

        assertEquals("EDIT_USER_PROFILE", actual.action)
    }

    @Test
    @Config(sdk = [23])
    fun testIsAtLeastAndroidOreo_LessThan26_ReturnsFalse() {
        val actual = viewModel.isAtLeastAndroidOreo()

        assertFalse(actual)
    }

    @Test
    @Config(sdk = [26])
    fun testIsAtLeastAndroidOreo_EqualTo26_ReturnsTrue() {
        val actual = viewModel.isAtLeastAndroidOreo()

        assertTrue(actual)
    }

    @Test
    @Config(sdk = [28])
    fun testIsAtLeastAndroidOreo_GreaterThan26_ReturnsTrue() {
        val actual = viewModel.isAtLeastAndroidOreo()

        assertTrue(actual)
    }

    @Test
    @Config(sdk = [23])
    fun demoObjectSpying() {
        // Note above: we're running on API 23; isAtLeastAndroidOreo() is supposed to return false.
        // We 'spy' the actual view model instance, and change the behaviour of isAtLeastAndroidOreo()
        // to always return true.

        val spy = spy(viewModel)
        doReturn(true).whenever(spy).isAtLeastAndroidOreo()

        val actual = spy.isAtLeastAndroidOreo()

        assertTrue(actual)
    }
}
