package za.co.dvt.android.testing

import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class RxViewModelTest {

    @Mock
    lateinit var repo : Repository
    lateinit var systemUnderTest: RxViewModel
    @Mock
    lateinit var view: TheView


    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        systemUnderTest = RxViewModel(view, repo)
    }

    @Test
    fun test_fetchPlants_ReturnsListOfPlants(){

        val expectedListOfPlants = arrayListOf(Plant("Tree"))
        Mockito.`when`(repo.getPlants()).thenReturn(Flowable.just(arrayListOf(Plant("Tree"))))
        Mockito.doNothing().`when`(view).showSuccessfulMessage()
        val actual = systemUnderTest.fetchPlants().test()
        actual.assertValue(expectedListOfPlants)
        Mockito.verify(repo).getPlants()
        Mockito.verify(view, Mockito.times(1)).showSuccessfulMessage()
    }

    @Test
    fun test_FetchesPlants_ReturnsEmptyList() {

        Mockito.`when`(repo.getPlants()).thenReturn(Flowable.just(arrayListOf(Plant("Plant"))))
        Mockito.doNothing().`when`(view).showSuccessfulMessage()
        val actual = systemUnderTest.fetchPlants().test()
        val result = actual.events.first().map { it }.first() as ArrayList<Plant>
        assert(result.isEmpty())
        Mockito.verify(repo).getPlants()
        Mockito.verify(view, Mockito.times(1)).showSuccessfulMessage()
    }
}