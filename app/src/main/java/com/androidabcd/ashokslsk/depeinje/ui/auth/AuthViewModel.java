package com.androidabcd.ashokslsk.depeinje.ui.auth;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.ViewModel;

import com.androidabcd.ashokslsk.depeinje.SessionManager;
import com.androidabcd.ashokslsk.depeinje.models.User;
import com.androidabcd.ashokslsk.depeinje.network.auth.AuthAPI;

import javax.inject.Inject;

import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class AuthViewModel extends ViewModel {

    private static final String TAG = "AuthViewModel";
    private final AuthAPI authAPI;
    private SessionManager sessionManager;

    @Inject
    public AuthViewModel(AuthAPI authAPI, SessionManager sessionManager) {
        this.authAPI = authAPI;
        this.sessionManager = sessionManager;
        Log.d(TAG, "AuthViewModel: view model is working machaa...");
        if (this.authAPI == null){
            Log.d(TAG, "AuthViewModel: Auth API is null");
        }else{
            Log.d(TAG, "AuthViewModel: auth api is working");
        }
    }

    public void authenticationWithId(int userId){
        Log.d(TAG, "authenticationWithId: attempting to login");
        sessionManager.authenticateWithId(queyUserId(userId));
    }


    private LiveData<AuthResource<User>> queyUserId(int userId){
        return LiveDataReactiveStreams.fromPublisher(authAPI.getUser(userId)
                .onErrorReturn(new Function<Throwable, User>() {
                    @Override
                    public User apply(Throwable throwable) throws Exception {
                        User errorUser = new User();
                        errorUser.setId(-1);
                        return errorUser;
                    }
                })
                .map(new Function<User, AuthResource<User>>() {
                    @Override
                    public AuthResource<User> apply(User user) throws Exception {
                        if (user.getId() == -1){
                            AuthResource.error("Could not authenticate", (User)null);
                        }
                        return AuthResource.authenticated(user);
                    }
                })
                .subscribeOn(Schedulers.io()));
    }

    public LiveData<AuthResource<User>> observeAuthState(){
        return sessionManager.getAuthUser();
    }
}
