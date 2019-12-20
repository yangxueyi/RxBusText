package com.yxy.rxbustext.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.yxy.rxbustext.R
import com.yxy.rxbustext.viewmodel.MyViewmodel
import kotlinx.android.synthetic.main.my_fragment.*

/**
 * Created by YangXueYi
 * Time : jajaying on 2019/11/18 14:28
 */
class MyFragment : Fragment() {
    private var myView :View?=null

    private val myViewmodel : MyViewmodel by lazy {
        ViewModelProviders.of(this).get(MyViewmodel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        if (myView == null){
            myView = inflater.inflate(R.layout.my_fragment, container, false)
        }

        return myView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        myViewmodel.myName.observe(this, Observer {myName ->
            my_tv.text = myName
        })


    }

}