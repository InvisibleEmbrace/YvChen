package com.kotlin.base.rx

import com.kotlin.base.presenter.view.BaseView
import rx.Subscriber

/*
    Rx订阅者默认实现
 */
open class BaseSubscriber<T>() : Subscriber<T>() {

    override fun onCompleted() {

    }

    override fun onNext(t: T) {
    }

    override fun onError(e: Throwable?) {

    }
}
