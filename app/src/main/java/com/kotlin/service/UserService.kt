package com.kotlin.service

import android.text.LoginFilter
import com.kotlin.base.data.protocol.BaseResponse
import com.kotlin.data.protocol.UserInfo
import rx.Observable


/**
 * Created by Administrator on 2018/3/10/010.
 */
interface UserService {

    fun login(username: String, password: String): Observable<UserInfo>
}