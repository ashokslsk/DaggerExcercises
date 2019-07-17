package com.androidabcd.ashokslsk.depeinje.di;

import com.androidabcd.ashokslsk.depeinje.di.auth.AuthModule;
import com.androidabcd.ashokslsk.depeinje.di.auth.AuthViewModelsModule;
import com.androidabcd.ashokslsk.depeinje.ui.auth.AuthActivity;
import com.androidabcd.ashokslsk.depeinje.ui.auth.AuthViewModel;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = {AuthViewModelsModule.class, AuthModule.class})
    abstract AuthActivity contributeActivity();

}
