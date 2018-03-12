package com.kotlin.data.repository

import com.kotlin.base.data.net.RetrofitFactory
import com.kotlin.base.data.protocol.BaseResponse
import com.kotlin.data.api.UserApi
import com.kotlin.data.protocol.LoginRequest
import com.kotlin.data.protocol.UserInfo
import rx.Observable
import javax.inject.Inject

/**
 * Created by Administrator on 2018/3/10/010.
 */
class UserRepository @Inject constructor() {

    fun login(username: String, password: String): Observable<BaseResponse<UserInfo>> {
        return RetrofitFactory.instance.create(UserApi::class.java).login(LoginRequest(username, password))
    }

}