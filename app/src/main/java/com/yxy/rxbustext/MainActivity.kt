package com.yxy.rxbustext

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.flyco.tablayout.listener.CustomTabEntity
import com.flyco.tablayout.listener.OnTabSelectListener
import com.yxy.rxbustext.bean.RxBusBean
import com.yxy.rxbustext.fragment.HomeFragment
import com.yxy.rxbustext.fragment.LoginFragment
import com.yxy.rxbustext.fragment.MyFragment
import com.yxy.rxbustext.fragment.TwoFragment
import com.yxy.rxbustext.utils.RxBus
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : AppCompatActivity() {

    private val  comTabList = arrayListOf<CustomTabEntity>()
    private var fragmentList = arrayListOf<Fragment>()

    private val titleList = arrayListOf("首页","邀请","我的","登录")
    private val mIconUnselectIds = intArrayOf(
        R.mipmap.icon_home,
        R.mipmap.icon_invest_gray,
        R.mipmap.icon_my_gray,
        R.mipmap.icon_invite_gray
    )
    private val mIconSelectIds = intArrayOf(
        R.mipmap.icon_home_red,
        R.mipmap.icon_invest_red,
        R.mipmap.icon_my_red,
        R.mipmap.icon_invite_red
    )

    private val homeFragment : Fragment by lazy {
        HomeFragment()
    }
    private val twoFragment : Fragment by lazy {
        TwoFragment()
    }

    private val myFragment : Fragment by lazy {
        MyFragment()
    }
    private val loginFragment : Fragment by lazy {
        LoginFragment()
    }
//    private var homeFragment : Fragment? = null
//    private var twoFragment : Fragment? = null
//    private var myFragment: Fragment? = null
//    private var loginFragment : Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       val actionBar = supportActionBar
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true) //显示NavigationIcon,这个方法是ActionBar的方法.Toolbar没有这个方法.
            actionBar.setDisplayShowTitleEnabled(false) //去除标题
            tool_bar_my_invest.setNavigationIcon(R.mipmap.icon_edit)
        }
        toolbar_title.text = "main"



        initFargment()
    }



    private fun initFargment() {
        for (i in  titleList.indices){
            comTabList.add(TabEntity(titleList[i],mIconSelectIds[i],mIconUnselectIds[i]))
        }

        fragmentList.add(homeFragment)
        fragmentList.add(twoFragment)
        fragmentList.add(myFragment)
        fragmentList.add(loginFragment)

        common_tab_layout.setTabData(comTabList,this,R.id.frame_layout,fragmentList)

        common_tab_layout.setOnTabSelectListener(object  : OnTabSelectListener{
            override fun onTabSelect(position: Int) {
                common_tab_layout.currentTab = position
               if (position == 1){
                   RxBus.getInstance()?.post(RxBusBean(0))
               }
            }
            override fun onTabReselect(position: Int) {

            }

        })

    }
}
