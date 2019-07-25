package com.androidabcd.ashokslsk.depeinje.ui.main.posts;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.androidabcd.ashokslsk.depeinje.SessionManager;
import com.androidabcd.ashokslsk.depeinje.network.main.MainApi;

import javax.inject.Inject;

public class PostsViewModel extends ViewModel {
    private static final String TAG = "PostsViewModel";

    // Inject
    private final SessionManager sessionManager;
    private final MainApi mainApi;

    @Inject
    public PostsViewModel(SessionManager sessionManager, MainApi mainApi) {
        this.sessionManager = sessionManager;
        this.mainApi = mainApi;

        Log.d(TAG, "PostsViewModel: View model main is working");
    }

}
