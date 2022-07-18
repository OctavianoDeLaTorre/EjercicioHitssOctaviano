package ejercicio.hitss.octaviano.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ejercicio.hitss.octaviano.provider.retrofit.RetrofitClient

open class BaseViewModel : ViewModel() {
    protected val provider = RetrofitClient.getInstance()

    protected val _loading: MutableLiveData<Boolean> = MutableLiveData()
    val loading: LiveData<Boolean> = _loading
}