package com.yxy.rxbustext.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.yxy.rxbustext.R

/**
 * Created by YangXueYi
 * Time : jajaying on 2019/11/18 14:28
 */
class MyFragment : Fragment() {
    private var myView :View?=null
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

}