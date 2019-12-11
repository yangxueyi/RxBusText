package com.yxy.rxbustext.utils

import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.Subject
import java.util.*

/**
 * Created by YangXueYi
 * Time : jajaying on 2019/11/18 12:13
 */
class RxBus {

    var myRxBus : Subject<Any>? = null

    init {
        myRxBus = PublishSubject.create<Any>().toSerialized()
    }
    companion object{
         var rxBus: RxBus? = null
        fun  getInstance(): RxBus? {
            if (rxBus == null){
                synchronized(RxBus::class.java){
                    rxBus = RxBus()
                }
            }
            return rxBus
        }
    }

    /**发送消息*/
    fun post(any: Any){
        myRxBus?.onNext(any)
    }

    /**
     * 接受消息
     * 转换为特定类型的Obserbale
     */
    fun <T> toObserbale(tyle : Class<T>) : Observable<T>? {
        return myRxBus?.ofType(tyle)
    }
}