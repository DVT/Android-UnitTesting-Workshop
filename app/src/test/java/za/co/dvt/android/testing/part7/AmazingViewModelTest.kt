package za.co.dvt.android.testing.part7

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.Dispatchers.Unconfined
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class AmazingViewModelTest {
    private lateinit var viewModel: AmazingViewModel

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        viewModel = AmazingViewModel(Unconfined, Unconfined)
    }

    @Test
    fun testInitialise_PostsNames() {
        viewModel.initialise()

        val actual = viewModel.names.value
        val expected = listOf(
                "Education of Mohammad Hussein, The",
                "Star Wars Uncut: Director's Cut",
                "Captain America: The First Avenger",
                "First Love, Last Rites"
        )
        assertEquals(expected, actual)
    }
}