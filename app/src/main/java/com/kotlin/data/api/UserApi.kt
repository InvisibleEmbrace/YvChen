package com.kotlin.data.api

import com.kotlin.base.data.protocol.BaseResponse
import com.kotlin.data.protocol.LoginRequest
import com.kotlin.data.protocol.UserInfo
import retrofit2.http.Body
import retrofit2.http.POST
import rx.Observable

/**
 * Created by Administrator on 2018/3/10/010.
 */
interface UserApi {

    @POST("/auth")
    fun login(@Body loginRequest: LoginRequest): Observable<BaseResponse<UserInfo>>


}