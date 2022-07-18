package ejercicio.hitss.octaviano.usecase.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ejercicio.hitss.octaviano.model.SearchResult
import ejercicio.hitss.octaviano.utils.BaseViewModel

class SearchViewModel : BaseViewModel() {

    /**
     * Lista con resultados de busqueda.
     */
    private val _searchResults: MutableLiveData<List<SearchResult>> =
        MutableLiveData<List<SearchResult>>()
    val searchResults: LiveData<List<SearchResult>> = _searchResults

    /**
     * Hacer la consulta de shows de tv.
     */
    fun search(query: String) {
        launchIO {
            _searchResults.postValue(provider.search(query))
            _loading.postValue(false)
        }
    }
}