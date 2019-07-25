package com.androidabcd.ashokslsk.depeinje.ui.main.profile;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.androidabcd.ashokslsk.depeinje.R;
import com.androidabcd.ashokslsk.depeinje.models.User;
import com.androidabcd.ashokslsk.depeinje.ui.auth.AuthResource;
import com.androidabcd.ashokslsk.depeinje.viewmodels.ViewModelProvidersFactory;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

public class ProfileFragment extends DaggerFragment {

    private static final String TAG = "ProfileFragment";
    private ProfileViewModel profileViewModel;
    private TextView email, username, website;

    @Inject
    ViewModelProvidersFactory providersFactory;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onViewCreated: profile fragment was created");
        email = view.findViewById(R.id.email);
        username = view.findViewById(R.id.username);
        website = view.findViewById(R.id.website);
        profileViewModel = ViewModelProviders.of(this, providersFactory).get(ProfileViewModel.class);
        subscribeObservers();
    }

    private void subscribeObservers(){
        profileViewModel.getAuthenticatedUser().removeObservers(getViewLifecycleOwner());
        profileViewModel.getAuthenticatedUser().observe(getViewLifecycleOwner(), new Observer<AuthResource<User>>() {
            @Override
            public void onChanged(AuthResource<User> userAuthResource) {
                if (userAuthResource != null){
                    switch (userAuthResource.status){
                        case AUTHENTICATED:
                            setUserDetails(userAuthResource.data);
                            break;
                        case ERROR:
                            setErrordetails(userAuthResource.message);
                            break;
                        case LOADING:
                            break;
                        case NOT_AUTHENTICATED:
                            break;
                    }
                }
            }
        });
    }

    private void setErrordetails(String message) {
        email.setText(message);
        username.setText("error");
        website.setText("error");
    }

    private void setUserDetails(User data) {
        email.setText(data.getEmail());
        username.setText(data.getUserName());
        website.setText(data.getWebsite());
    }
}
