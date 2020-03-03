package za.co.dvt.android.testing.part5

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations.initMocks
import za.co.dvt.android.testing.part5.code.MovieProvider

class MovieListViewModelTest {
    @Mock
    private lateinit var movieProvider: MovieProvider
    private lateinit var movieListViewModel: MovieListViewModel

    @Before
    fun setUp() {
        initMocks(this)
        movieListViewModel = MovieListViewModel(movieProvider)
    }

    @Test
    fun testFilterMovies_NullQuery_ReturnsFullList() {
        `when`(movieProvider.provideMovies()).thenReturn(provideMockMovies())

        val actual = movieListViewModel.filterMovies(null)

        assertEquals(3, actual.size)
        assertTrue(actual.contains("First"))
        assertTrue(actual.contains("Second"))
        assertTrue(actual.contains("Third"))
    }

    @Test
    fun testFilterMovies_EmptyQuery_ReturnsFullList() {
        `when`(movieProvider.provideMovies()).thenReturn(provideMockMovies())

        val actual = movieListViewModel.filterMovies("")

        assertEquals(3, actual.size)
        assertTrue(actual.contains("First"))
        assertTrue(actual.contains("Second"))
        assertTrue(actual.contains("Third"))
    }

    @Test
    fun testFilterMovies_ValidQuery_ReturnsMatchingMovies() {
        `when`(movieProvider.provideMovies()).thenReturn(provideMockMovies())

        val actual = movieListViewModel.filterMovies("ir")

        assertEquals(2, actual.size)
        assertTrue(actual.contains("First"))
        assertTrue(actual.contains("Third"))
    }

    private fun provideMockMovies(): Collection<String> {
        return listOf("First", "Second", "Third")
    }
}