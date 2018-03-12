package com.kotlin.ui.activity

import android.os.Bundle
import android.view.View
import com.kotlin.R
import com.kotlin.R.id.*
import com.kotlin.base.common.BaseApplication
import com.kotlin.base.ext.enable
import com.kotlin.base.ext.onClick
import com.kotlin.base.ui.activity.BaseMvpActivity
import com.kotlin.data.protocol.User
import com.kotlin.injection.component.DaggerUserComponent
import com.kotlin.injection.module.UserModule
import com.kotlin.prsenter.LoginPresenter
import com.kotlin.prsenter.view.LoginView
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.*

class LoginActivity : BaseMvpActivity<LoginPresenter>(), LoginView, View.OnClickListener {

    override fun onLoginResult(result: User) {
        toast("登录成功")
        println("结果：$result")
        println("用户：${result}")
        startActivity<MainActivity>()
    }

    override fun injectComponent() {
        DaggerUserComponent.builder().activityComponent(mActivityComponent).userModule(UserModule()).build().inject(this)
        mPresenter.mView = this
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initView()
    }

    /*
        初始化视图
     */
    private fun initView() {

        mLoginBtn.enable(mUserNameEt, { isBtnEnable() })
        mLoginBtn.enable(mPwdEt, { isBtnEnable() })

        mLoginBtn.onClick(this)

    }


    /*
        点击事件
     */
    override fun onClick(view: View) {
        when (view.id) {
            R.id.mLoginBtn -> {
                mPresenter.login(mUserNameEt.text.toString(), mPwdEt.text.toString())
            }
        }
    }

    /*
        判断按钮是否可用
     */
    private fun isBtnEnable(): Boolean {
        return mUserNameEt.text.isNullOrEmpty().not() &&
                mPwdEt.text.isNullOrEmpty().not()
    }


}
