package com.androidabcd.ashokslsk.depeinje.di;

import com.androidabcd.ashokslsk.depeinje.AuthActivity;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilderModule {

    @ContributesAndroidInjector
    abstract AuthActivity contributeActivity();

}
