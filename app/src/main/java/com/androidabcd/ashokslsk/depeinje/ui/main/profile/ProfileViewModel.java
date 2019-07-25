package com.androidabcd.ashokslsk.depeinje.ui.main.profile;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.androidabcd.ashokslsk.depeinje.SessionManager;
import com.androidabcd.ashokslsk.depeinje.models.User;
import com.androidabcd.ashokslsk.depeinje.ui.auth.AuthResource;

import javax.inject.Inject;

public class ProfileViewModel extends ViewModel {
    private static final String TAG = "ProfileViewModel";

    private final SessionManager sessionManager;

    @Inject
    public ProfileViewModel(SessionManager sessionManager) {
        Log.d(TAG, "ProfileViewModel: viewmodel is ready");
        this.sessionManager = sessionManager;
    }

    public LiveData<AuthResource<User>> getAuthenticatedUser(){
        return sessionManager.getAuthUser();
    }
}
