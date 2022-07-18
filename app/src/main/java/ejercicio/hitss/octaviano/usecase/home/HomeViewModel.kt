package ejercicio.hitss.octaviano.usecase.home

import androidx.lifecycle.*
import ejercicio.hitss.octaviano.model.ScheduleElement
import ejercicio.hitss.octaviano.utils.BaseViewModel
import ejercicio.hitss.octaviano.utils.DateUtility

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
        launchIO {
            _tvPrograms.postValue(provider.getScheduleOf(date = DateUtility.getDate()))
        }
    }


}