package ejercicio.hitss.octaviano.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ejercicio.hitss.octaviano.provider.retrofit.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * BaseViewModel
 */
open class BaseViewModel : ViewModel() {
    protected val provider = RetrofitClient.getInstance()

    protected val _loading: MutableLiveData<Boolean> = MutableLiveData()
    val loading: LiveData<Boolean> = _loading

    protected val _error: MutableLiveData<Boolean> = MutableLiveData()
    val error: LiveData<Boolean> = _error

    fun launchIO(function: suspend ()->Unit){
        setLoadingState()
        viewModelScope.launch(Dispatchers.IO) {
            try {
                function()
            } catch (e: Exception){
                _error.postValue(true)
            }
            _loading.postValue(false)
        }
    }

    fun setLoadingState(){
        _loading.value = true
        _error.value = false
    }
}