package com.yxy.rxbustext.fragment

import android.content.Intent
import android.database.Observable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.yxy.rxbustext.R
import com.yxy.rxbustext.TwoActivity
import com.yxy.rxbustext.bean.RxBusBean
import com.yxy.rxbustext.utils.RxBus
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.home_fragment.*

/**
 * Created by YangXueYi
 * Time : jajaying on 2019/11/18 14:28
 */
class HomeFragment : Fragment() {

    private var myView :View?=null
    lateinit var disposable : Disposable
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        if (myView == null){
            myView = inflater.inflate(R.layout.home_fragment, container, false)
        }

        return myView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        go_two.setOnClickListener {
            startActivity(Intent(activity,TwoActivity::class.java))
        }

        tv.setOnClickListener{
            RxBus.getInstance()?.post(RxBusBean(0))
        }
        onfresh()
    }

    private fun onfresh() {

         RxBus.getInstance()?.toObserbale(RxBusBean::class.java)
            ?.subscribe(object : Observer<RxBusBean> {
                override fun onComplete() {
                }

                override fun onSubscribe(d: Disposable) {
                    disposable = d
                }

                override fun onNext(t: RxBusBean) {
                    if (t.tyle == 1){
                        Toast.makeText(activity,"传送成功",Toast.LENGTH_SHORT).show()
                        tv.text = "传送成功"
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