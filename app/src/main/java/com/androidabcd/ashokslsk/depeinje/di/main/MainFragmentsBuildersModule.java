package com.androidabcd.ashokslsk.depeinje.di.main;

import com.androidabcd.ashokslsk.depeinje.ui.main.posts.PostsFragments;
import com.androidabcd.ashokslsk.depeinje.ui.main.profile.ProfileFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainFragmentsBuildersModule {

    @ContributesAndroidInjector
    abstract ProfileFragment contributeProfileFragment();


    @ContributesAndroidInjector
    abstract PostsFragments contributePostFragment();

}
