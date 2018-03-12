package com.kotlin.data.protocol

/**
 * Created by Administrator on 2018/3/10/010.
 */

data class User(val id: Int,
                val name: String,
                val username: String,
                val password: String,
                val role_id: Int,
                val employee_token: String,
                val avatar: String,
                val phone: String,
                val status: Int,
                val token: String)