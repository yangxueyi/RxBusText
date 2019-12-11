package com.yxy.rxbustext.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.yxy.rxbustext.R
import com.yxy.rxbustext.bean.RxBusBean
import com.yxy.rxbustext.utils.RxBus
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.two_fragment.*

/**
 * Created by YangXueYi
 * Time : jajaying on 2019/11/18 14:28
 */
class TwoFragment : Fragment() {
    private var myView: View? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        if (myView == null) {
            myView = inflater.inflate(R.layout.two_fragment, container, false)
        }

        return myView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        onHome()

    }

    private lateinit var disposable: Disposable

    private fun onHome() {
        RxBus.getInstance()?.toObserbale(RxBusBean::class.java)?.subscribe(object :
            Observer<RxBusBean> {
            override fun onComplete() {
            }

            override fun onSubscribe(d: Disposable) {
                disposable = d
            }

            override fun onNext(t: RxBusBean) {
                if (t.tyle == 0){
                    tv_two.text = "我是来自homefragment的消息"
                }
            }

            override fun onError(e: Throwable) {
            }

        })
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.dispose()
    }

}