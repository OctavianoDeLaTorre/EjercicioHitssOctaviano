package ejercicio.hitss.octaviano.usecase.showdetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import ejercicio.hitss.octaviano.model.Cast
import ejercicio.hitss.octaviano.model.Show
import ejercicio.hitss.octaviano.utils.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

open class ShowDetailsViewModel : BaseViewModel() {

    //Informacion del show seleccionado
    private val _show: MutableLiveData<Show> = MutableLiveData()
    val show: LiveData<Show> = _show

    //Lista de actores del show
    private val _cast: MutableLiveData<List<Cast>> = MutableLiveData()
    val cast: LiveData<List<Cast>> = _cast

    /**
     * Obtiene la infromación completa de show.
     *
     * @param id Id del show de tv
     */
    fun getShow(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            _show.postValue(provider.getShow(id))
        }
    }

    /**
     * Obtiene la lista completa de actores de un show de tv.
     *
     * @param idShow Id del show de tv.
     */
    fun getCast(idShow: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            _cast.postValue(provider.getCast(idShow))
        }
    }
}