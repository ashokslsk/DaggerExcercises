package com.androidabcd.ashokslsk.depeinje.di.main;

import com.androidabcd.ashokslsk.depeinje.network.main.MainApi;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class MainModule {

    @Provides
    static MainApi provideMainApi(Retrofit retrofit){
        return retrofit.create(MainApi.class);
    }
}
