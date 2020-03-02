package za.co.dvt.android.testing.part5

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations.initMocks

class Part5Test {
    @Mock
    private lateinit var nameProvider: NameProvider
    private lateinit var part5: Part5

    @Before
    fun setUp() {
        initMocks(this)
        part5 = Part5(nameProvider)
    }

    @Test
    fun testFilterNames_NullQuery_ReturnsFullList() {
        `when`(nameProvider.provideNames()).thenReturn(provideMockNames())

        val actual = part5.filterNames(null)

        assertEquals(3, actual.size)
        assertTrue(actual.contains("First"))
        assertTrue(actual.contains("Second"))
        assertTrue(actual.contains("Third"))
    }

    @Test
    fun testFilterNames_EmptyQuery_ReturnsFullList() {
        `when`(nameProvider.provideNames()).thenReturn(provideMockNames())

        val actual = part5.filterNames("")

        assertEquals(3, actual.size)
        assertTrue(actual.contains("First"))
        assertTrue(actual.contains("Second"))
        assertTrue(actual.contains("Third"))
    }

    @Test
    fun testFilterNames_ValidQuery_ReturnsMatchingNames() {
        `when`(nameProvider.provideNames()).thenReturn(provideMockNames())

        val actual = part5.filterNames("ir")

        assertEquals(2, actual.size)
        assertTrue(actual.contains("First"))
        assertTrue(actual.contains("Third"))
    }

    private fun provideMockNames(): Collection<String> {
        return listOf("First", "Second", "Third")
    }
}