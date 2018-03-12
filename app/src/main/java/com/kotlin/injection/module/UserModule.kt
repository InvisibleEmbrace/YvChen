package com.kotlin.injection.module

import com.kotlin.base.injection.PerComponentScope
import com.kotlin.service.UserService
import com.kotlin.service.impl.UserServiceImpl
import dagger.Module
import dagger.Provides

/**
 * Created by Administrator on 2018/3/12/012.
 */
@PerComponentScope
@Module
class UserModule {

    @Provides
    fun providesUserService(userService: UserServiceImpl): UserService {
        return userService
    }
}