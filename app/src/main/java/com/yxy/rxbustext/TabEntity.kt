package com.yxy.rxbustext

import com.flyco.tablayout.listener.CustomTabEntity

/**
 * Created by YangXueYi
 * Time : jajaying on 2019/11/18 14:09
 */
class TabEntity : CustomTabEntity {

    var title: String? = null
    var selectIcon : Int
    var unSelectIcon : Int

    constructor(title: String?, selectIcon: Int, unSelectIcon: Int) {
        this.title = title
        this.selectIcon = selectIcon
        this.unSelectIcon = unSelectIcon
    }


    override fun getTabUnselectedIcon(): Int {
        return unSelectIcon
    }

    override fun getTabSelectedIcon(): Int {
        return selectIcon
    }

    override fun getTabTitle(): String? {
        return title
    }
}