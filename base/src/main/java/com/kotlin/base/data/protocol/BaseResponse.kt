package com.kotlin.base.data.protocol

/**
 * Created by Administrator on 2018/3/10/010.
 */
data class BaseResponse<out T>(val success:Boolean, val errMsg:String, val data:T)