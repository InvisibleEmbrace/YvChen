package com.kotlin.service.impl

import com.kotlin.base.data.protocol.BaseResponse
import com.kotlin.base.rx.BaseException
import com.kotlin.base.rx.BaseSubscriber
import com.kotlin.data.protocol.UserInfo
import com.kotlin.data.repository.UserRepository
import com.kotlin.service.UserService
import rx.Observable
import rx.Scheduler
import rx.android.schedulers.AndroidSchedulers
import rx.functions.Func1
import rx.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Administrator on 2018/3/12/012.
 */
class UserServiceImpl @Inject constructor() : UserService {

    @Inject
    lateinit var userRepository: UserRepository

    override fun login(username: String, password: String): Observable<UserInfo> {
        return userRepository.login(username, password)
                .flatMap(Func1<BaseResponse<UserInfo>, Observable<UserInfo>> { t ->
                    if (!t.success) {
                        return@Func1 Observable.error(BaseException(1, t.errMsg))
                    }
                    Observable.just(t.data)
                })
    }
}