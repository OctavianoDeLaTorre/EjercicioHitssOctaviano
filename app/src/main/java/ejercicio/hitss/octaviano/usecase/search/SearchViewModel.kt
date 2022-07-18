package ejercicio.hitss.octaviano.usecase.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import ejercicio.hitss.octaviano.model.SearchResult
import ejercicio.hitss.octaviano.utils.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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
        _loading.value = true
        viewModelScope.launch(Dispatchers.IO) {
            _searchResults.postValue(provider.search(query))
            _loading.postValue(false)
        }
    }
}