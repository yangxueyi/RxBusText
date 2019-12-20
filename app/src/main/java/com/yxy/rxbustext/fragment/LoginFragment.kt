package com.yxy.rxbustext.fragment

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.yxy.rxbustext.R

/**
 * Created by YangXueYi
 * Time : jajaying on 2019/11/18 14:28
 */
class LoginFragment : Fragment() {

    private var myView :View? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        if (myView == null){
            myView = inflater.inflate(R.layout.login_fragment, container, false)
        }

        return myView
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val ssss :(activity : Activity) -> Unit = {activity -> "jjjjj" }
    }

}