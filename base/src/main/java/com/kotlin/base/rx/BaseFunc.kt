package com.kotlin.base.rx

import com.kotlin.base.data.protocol.BaseResponse
import rx.Observable
import rx.functions.Func1

/*
    通用数据类型转换封装
 */
class BaseFunc<T> : Func1<BaseResponse<T>, Observable<T>> {
    override fun call(t: BaseResponse<T>): Observable<T> {
        if (!t.success) {
            return Observable.error(BaseException(1, t.errMsg))
        }
        return Observable.just(t.data)
    }
}
