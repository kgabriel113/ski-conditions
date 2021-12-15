package com.example.pnwskiconditions

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SnoqualmieViewModel: ViewModel() {

    private var _updateTime = MutableLiveData("No update time available")
    //temperature only for now, TODO create an object for temp/snowfall
    private var _alpental = MutableLiveData(0.0)
    private var _alpentalMid = MutableLiveData(1.0)
    private var _alpentalTop = MutableLiveData(2.0)
    private var _summitWest = MutableLiveData(3.0)
    private var _comments = MutableLiveData("No comments available for Snoqualmie Pass")
    private var _temperature = _alpental

    val updateTime: LiveData<String> = _updateTime
    val temperature: LiveData<Double> = _temperature
    val comments: LiveData<String> = _comments

    fun setArea(area: Int){
        val newTemp = when(area){
            1 -> _alpentalMid.value
            2 -> _alpentalTop.value
            3 -> _summitWest.value
            else -> _alpental.value
        }

        _temperature.value = newTemp
        Log.d("DEBUG", "new temperature ${_temperature.value}")
    }


}