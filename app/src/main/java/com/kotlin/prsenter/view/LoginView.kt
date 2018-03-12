package com.kotlin.prsenter.view

import com.kotlin.base.presenter.view.BaseView
import com.kotlin.data.protocol.User

/**
 * Created by Administrator on 2018/3/12/012.
 */
interface LoginView : BaseView {

    fun onLoginResult(result: User)

}