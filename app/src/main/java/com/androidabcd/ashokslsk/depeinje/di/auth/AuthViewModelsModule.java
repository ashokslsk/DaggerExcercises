package com.androidabcd.ashokslsk.depeinje.di.auth;

import androidx.lifecycle.ViewModel;

import com.androidabcd.ashokslsk.depeinje.di.ViewModelKey;
import com.androidabcd.ashokslsk.depeinje.ui.auth.AuthViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class AuthViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel.class)
    public abstract ViewModel bindAuthViewModel(AuthViewModel viewModel);

}
