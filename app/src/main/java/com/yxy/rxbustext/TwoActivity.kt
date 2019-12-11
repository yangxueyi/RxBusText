package com.yxy.rxbustext

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.yxy.rxbustext.bean.RxBusBean
import com.yxy.rxbustext.utils.RxBus
import kotlinx.android.synthetic.main.activity_two.*
import kotlinx.android.synthetic.main.toolbar.*

class TwoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)


        this.setSupportActionBar(tool_bar_my_invest)
        val actionBar = supportActionBar
        if (actionBar != null) {
//            actionBar.hide()
            actionBar.setDisplayHomeAsUpEnabled(true) //显示NavigationIcon,这个方法是ActionBar的方法.Toolbar没有这个方法.
            actionBar.setDisplayShowTitleEnabled(false) //去除标题
            tool_bar_my_invest.setNavigationIcon(R.mipmap.icon_edit)
        }

        toolbar_title.text = "two"

        rx_bus.setOnClickListener {
            RxBus.getInstance()?.post(RxBusBean(1))
        }


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
