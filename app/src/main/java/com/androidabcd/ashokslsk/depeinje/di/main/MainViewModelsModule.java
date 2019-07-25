package com.androidabcd.ashokslsk.depeinje.di.main;

import androidx.lifecycle.ViewModel;

import com.androidabcd.ashokslsk.depeinje.di.ViewModelKey;
import com.androidabcd.ashokslsk.depeinje.ui.main.posts.PostsViewModel;
import com.androidabcd.ashokslsk.depeinje.ui.main.profile.ProfileViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class MainViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel.class)
    public abstract ViewModel bindProfileViewModel(ProfileViewModel viewModel);

    @Binds
    @IntoMap
    @ViewModelKey(PostsViewModel.class)
    public abstract ViewModel bindPostsViewModel(PostsViewModel viewModel);
}
