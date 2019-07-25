package com.androidabcd.ashokslsk.depeinje;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

import com.androidabcd.ashokslsk.depeinje.models.User;
import com.androidabcd.ashokslsk.depeinje.ui.auth.AuthActivity;
import com.androidabcd.ashokslsk.depeinje.ui.auth.AuthResource;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public abstract class BaseActivity extends DaggerAppCompatActivity {

    private static final String TAG = "BaseActivity";

    @Inject
    public SessionManager sessionManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        subscribeObservers();
    }

    private void subscribeObservers(){
        sessionManager.getAuthUser().observe(this, new Observer<AuthResource<User>>() {
            @Override
            public void onChanged(AuthResource<User> userAuthResource) {
                if (userAuthResource != null){
                    switch (userAuthResource.status){

                        case AUTHENTICATED:
                            Log.d(TAG, "onChanged: Login success"+ userAuthResource.data.getEmail());
                            break;
                        case ERROR:
                            Log.d(TAG, "onChanged: ");
                            break;
                        case LOADING:
                            Log.d(TAG, "onChanged: ");
                            break;
                        case NOT_AUTHENTICATED:
                            Log.d(TAG, "onChanged: ");
                            navLoginScreen();
                            break;
                    }
                }
            }
        });
    }

    private void navLoginScreen(){
        Intent intent = new Intent(this, AuthActivity.class);
        startActivity(intent);
        finish();
    }
}
