package ejercicio.hitss.octaviano.usecase.home

import android.util.Log
import androidx.lifecycle.*
import ejercicio.hitss.octaviano.model.ScheduleElement
import ejercicio.hitss.octaviano.provider.retrofit.RetrofitClient
import ejercicio.hitss.octaviano.utils.BaseViewModel
import ejercicio.hitss.octaviano.utils.DateUtility
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel : BaseViewModel() {

    //Lista de programas de tv
    private val _tvPrograms: MutableLiveData<List<ScheduleElement>> by lazy {
        MutableLiveData<List<ScheduleElement>>().also {
            getSchedule()
        }
    }
    val tvPrograms: LiveData<List<ScheduleElement>> = _tvPrograms

    //Fecha para mostrar en el titulo
    private val _dateFormated: MutableLiveData<String> by lazy {
        MutableLiveData<String>().also {
            it.value = DateUtility.getCurrentDate()
        }
    }
    val dateFormated: LiveData<String> = _dateFormated

    /**
     * Obtener las lista de programas de la fecha actual
     */
    fun getSchedule() {
        _loading.value = true
        viewModelScope.launch(Dispatchers.IO) {
            _tvPrograms.postValue(provider.getScheduleOf(date = DateUtility.getDate()))
            _loading.postValue(false)
        }
    }


}