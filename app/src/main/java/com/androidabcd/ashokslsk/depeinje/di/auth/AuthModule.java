package com.androidabcd.ashokslsk.depeinje.di.auth;

import com.androidabcd.ashokslsk.depeinje.network.auth.AuthAPI;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class AuthModule {

    @Provides
    static AuthAPI provideAuthApi(Retrofit retrofit){
        return retrofit.create(AuthAPI.class);
    }

}
