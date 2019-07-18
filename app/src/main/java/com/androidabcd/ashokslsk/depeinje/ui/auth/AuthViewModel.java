package com.androidabcd.ashokslsk.depeinje.ui.auth;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.androidabcd.ashokslsk.depeinje.models.User;
import com.androidabcd.ashokslsk.depeinje.network.auth.AuthAPI;
import javax.inject.Inject;
import io.reactivex.schedulers.Schedulers;

public class AuthViewModel extends ViewModel {

    private static final String TAG = "AuthViewModel";
    private final AuthAPI authAPI;
    private MediatorLiveData<User> authUser = new MediatorLiveData<>();

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

    public void authenticationWithId(int userId){
        final LiveData<User> source = LiveDataReactiveStreams.fromPublisher(
                authAPI.getUser(userId)
                .subscribeOn(Schedulers.io()));
        authUser.addSource(source, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                authUser.setValue(user);
                authUser.removeSource(source);
            }
        });
    }

    public LiveData<User> observeUser(){
        return authUser;
    }
}
