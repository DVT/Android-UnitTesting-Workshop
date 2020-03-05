package za.co.dvt.android.testing.part5

import com.nhaarman.mockitokotlin2.whenever
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations.initMocks
import za.co.dvt.android.testing.part5.code.MovieProvider

class MovieListViewModelTest {
    @Mock
    private lateinit var movieProvider: MovieProvider
    private lateinit var viewModel: MovieListViewModel

    @Before
    fun setUp() {
        initMocks(this)
        viewModel = MovieListViewModel(movieProvider)
    }

    @Test
    fun testFilterMovies_NullQuery_ReturnsFullList() {
        whenever(movieProvider.provideMovies()).thenReturn(provideMockMovies())

        val actual = viewModel.filterMovies(null)

        assertEquals(3, actual.size)
        assertTrue(actual.contains("First"))
        assertTrue(actual.contains("Second"))
        assertTrue(actual.contains("Third"))
    }

    @Test
    fun testFilterMovies_EmptyQuery_ReturnsFullList() {
        whenever(movieProvider.provideMovies()).thenReturn(provideMockMovies())

        val actual = viewModel.filterMovies("")

        assertEquals(3, actual.size)
        assertTrue(actual.contains("First"))
        assertTrue(actual.contains("Second"))
        assertTrue(actual.contains("Third"))
    }

    @Test
    fun testFilterMovies_ValidQuery_ReturnsMatchingMovies() {
        whenever(movieProvider.provideMovies()).thenReturn(provideMockMovies())

        val actual = viewModel.filterMovies("ir")

        assertEquals(2, actual.size)
        assertTrue(actual.contains("First"))
        assertTrue(actual.contains("Third"))
    }

    @Test
    fun testFilterMovies_QueryCaseIsDifferent_PerformsCaseInsensitiveFilter() {
        whenever(movieProvider.provideMovies()).thenReturn(provideMockMovies())

        val actual = viewModel.filterMovies("fir")

        assertEquals(1, actual.size)
        assertTrue(actual.contains("First"))
    }

    private fun provideMockMovies(): Collection<String> {
        return listOf("First", "Second", "Third")
    }
}