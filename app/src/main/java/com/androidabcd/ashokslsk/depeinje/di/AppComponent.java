package com.androidabcd.ashokslsk.depeinje.di;

import android.app.Application;

import com.androidabcd.ashokslsk.depeinje.BaseApplication;
import com.androidabcd.ashokslsk.depeinje.SessionManager;

import javax.inject.Singleton;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class, ActivityBuilderModule.class, AppModule.class, ViewModelFactoryModule.class,})
public interface AppComponent extends AndroidInjector<BaseApplication> {

    SessionManager sessonManager();

    @Component.Builder
    interface Builder{

        @BindsInstance
        Builder application(Application application);
        AppComponent build();
    }
}
