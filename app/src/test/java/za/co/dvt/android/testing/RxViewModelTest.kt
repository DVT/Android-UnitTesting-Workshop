package za.co.dvt.android.testing

import com.nhaarman.mockitokotlin2.doNothing
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Flowable
import junit.framework.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations.initMocks

class RxViewModelTest {
    @Mock
    lateinit var repo: Repository
    lateinit var systemUnderTest: RxViewModel

    @Mock
    lateinit var view: TheView

    @Before
    fun setup() {
        initMocks(this)
        systemUnderTest = RxViewModel(view, repo)
    }

    @Test
    fun test_fetchPlants_ReturnsListOfPlants() {
        val expectedListOfPlants = arrayListOf(Plant("Tree"))
        whenever(repo.getPlants()).thenReturn(Flowable.just(arrayListOf(Plant("Tree"))))
        doNothing().whenever(view).showSuccessfulMessage()

        val actual = systemUnderTest.fetchPlants().test()

        actual.assertValue(expectedListOfPlants)
        verify(repo).getPlants()
        verify(view, times(1)).showSuccessfulMessage()
    }

    @Test
    fun test_FetchesPlants_ReturnsEmptyList() {
        whenever(repo.getPlants()).thenReturn(Flowable.just(arrayListOf(Plant("Plant"))))
        doNothing().whenever(view).showSuccessfulMessage()

        val actual = systemUnderTest.fetchPlants().test()
        val result = actual.values()
        assertTrue(result.first().isEmpty())
        verify(repo).getPlants()
        verify(view, times(1)).showSuccessfulMessage()
    }
}