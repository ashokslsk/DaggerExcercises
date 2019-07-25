package com.androidabcd.ashokslsk.depeinje.ui.main.profile;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

import com.androidabcd.ashokslsk.depeinje.R;
import com.androidabcd.ashokslsk.depeinje.viewmodels.ViewModelProvidersFactory;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

public class ProfileFragment extends DaggerFragment {

    private static final String TAG = "ProfileFragment";
    private ProfileViewModel profileViewModel;

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
        profileViewModel = ViewModelProviders.of(this, providersFactory).get(ProfileViewModel.class);

    }
}
