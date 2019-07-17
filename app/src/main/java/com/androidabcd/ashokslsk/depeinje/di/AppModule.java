package com.androidabcd.ashokslsk.depeinje.di;

import android.app.Application;
import android.graphics.drawable.Drawable;

import androidx.core.content.ContextCompat;

import com.androidabcd.ashokslsk.depeinje.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    static RequestOptions provideRequestoptions(){
        return RequestOptions
                .placeholderOf(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher_round);
    }

    @Provides
    static RequestManager provideGlideInstance(Application application, RequestOptions requestOptions){

        return Glide.with(application)
                .setDefaultRequestOptions(requestOptions);
    }

    @Provides
    static Drawable provideAppDrawable(Application application){
        return ContextCompat.getDrawable(application, R.mipmap.ic_launcher_round);
    }
}
