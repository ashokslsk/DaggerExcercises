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

import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class AuthViewModel extends ViewModel {

    private static final String TAG = "AuthViewModel";
    private final AuthAPI authAPI;
    private MediatorLiveData<AuthResource<User>> authUser = new MediatorLiveData<>();

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
        authUser.setValue(AuthResource.loading((User)null));
        final LiveData<AuthResource<User>> source = LiveDataReactiveStreams.fromPublisher(
                authAPI.getUser(userId)
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
        authUser.addSource(source, new Observer<AuthResource<User>>() {
            @Override
            public void onChanged(AuthResource<User> userAuthResource) {
                authUser.setValue(userAuthResource);
                authUser.removeSource(source);
            }
        });
    }

    public LiveData<AuthResource<User>> observeUser(){
        return authUser;
    }
}
