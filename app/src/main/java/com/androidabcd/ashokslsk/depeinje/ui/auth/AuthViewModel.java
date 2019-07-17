package com.androidabcd.ashokslsk.depeinje.ui.auth;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.androidabcd.ashokslsk.depeinje.network.auth.AuthAPI;

import javax.inject.Inject;

public class AuthViewModel extends ViewModel {

    private static final String TAG = "AuthViewModel";
    private final AuthAPI authAPI;

    @Inject
    public AuthViewModel(AuthAPI authAPI) {
        this.authAPI = authAPI;
        Log.d(TAG, "AuthViewModel: view model is working machaa...");
        if (this.authAPI == null){
            Log.d(TAG, "AuthViewModel: Auth API is null");
        }else{
            Log.d(TAG, "AuthViewModel: auth api is working");
        }
    }
}
