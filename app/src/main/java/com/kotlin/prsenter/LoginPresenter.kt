package com.kotlin.prsenter

import com.kotlin.base.data.protocol.BaseResponse
import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.rx.BaseSubscriber
import com.kotlin.data.protocol.User
import com.kotlin.data.protocol.UserInfo
import com.kotlin.prsenter.view.LoginView
import com.kotlin.service.UserService
import rx.Observable
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.internal.operators.OperatorReplay.observeOn
import rx.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Administrator on 2018/3/12/012.
 */
class LoginPresenter @Inject constructor() : BasePresenter<LoginView>() {

    @Inject
    lateinit var userService: UserService

    fun login(username: String, password: String) {
        userService.login(username, password)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(object :Subscriber<UserInfo>(){
                    override fun onNext(t: UserInfo) {
                        mView.onLoginResult(t.user)
                    }

                    override fun onCompleted() {

                    }

                    override fun onError(e: Throwable?) {

                    }

                })



    }
}