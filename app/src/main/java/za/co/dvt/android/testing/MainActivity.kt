package za.co.dvt.android.testing

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity(R.layout.activity_main) , TheView {

    private val disposable = CompositeDisposable()

    private val viewModel: RxViewModel by lazy {
        return@lazy RxViewModel(this, RepositoryImpl())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fetchPlantList()
    }

    private fun fetchPlantList() {
        disposable.add(
                viewModel.fetchPlants().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe {
                    print(it.map { plant -> plant.name })
                })
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.dispose()
    }

    override fun onStop() {
        super.onStop()
        disposable.clear()
    }

    override fun showSuccessfulMessage() {
        print("Yaye")
    }
}

interface TheView {
    fun showSuccessfulMessage()
}

class RxViewModel (private  val view: TheView, private val repo: Repository ){

    fun fetchPlants() : Flowable<List<Plant>> {
        view.showSuccessfulMessage()
        return repo.getPlants().map { it.filter { plant ->  plant.name == "Tree" } }
    }
}

interface Repository  {
    fun getPlants(): Flowable<List<Plant>>
}

class RepositoryImpl : Repository  {
    override fun getPlants(): Flowable<List<Plant>> = Flowable.just(listOf(Plant("Tree", "Green")))
}

data class Plant (var name : String, var color : String = "Green")