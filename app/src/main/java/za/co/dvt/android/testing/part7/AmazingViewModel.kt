package za.co.dvt.android.testing.part7

import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class AmazingViewModel(
        private val mainContext: CoroutineContext,
        private val backgroundContext: CoroutineContext
) : ViewModel() {

    private val _names = MutableLiveData<List<String>>()
    val names: LiveData<List<String>> = _names

    fun initialise() {
        viewModelScope.launch(backgroundContext) {
            // Do stuff in background
            _names.postValue(serviceCall())
            withContext(mainContext) {
                // Do stuff on main thread
            }
        }
    }

    private suspend fun serviceCall(): List<String> {
        return listOf(
                "Education of Mohammad Hussein, The",
                "Star Wars Uncut: Director's Cut",
                "Captain America: The First Avenger",
                "First Love, Last Rites"
        )
    }

    class Factory : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            @Suppress("UNCHECKED_CAST")
            return AmazingViewModel(Main, IO) as T
        }
    }
}
