package com.androidabcd.ashokslsk.depeinje.di;

import androidx.lifecycle.ViewModelProvider;

import com.androidabcd.ashokslsk.depeinje.viewmodels.ViewModelProvidersFactory;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ViewModelFactoryModule {

    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelProvidersFactory modelProvidersFactory);


}
