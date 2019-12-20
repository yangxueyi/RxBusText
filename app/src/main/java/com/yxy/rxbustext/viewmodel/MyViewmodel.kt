package com.yxy.rxbustext.viewmodel

import android.os.SystemClock
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

/**
 * Created by YangXueYi
 * Time : jajaying on 2019/12/17 15:05
 */
class MyViewmodel : ViewModel() {
    val myName : MutableLiveData<String> = MutableLiveData()

    init {


        viewModelScope.launch {
            myName.value = "99999"
        }
    }




}