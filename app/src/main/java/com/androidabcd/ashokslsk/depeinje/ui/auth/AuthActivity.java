package com.androidabcd.ashokslsk.depeinje.ui.auth;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.androidabcd.ashokslsk.depeinje.R;
import com.androidabcd.ashokslsk.depeinje.models.User;
import com.androidabcd.ashokslsk.depeinje.viewmodels.ViewModelProvidersFactory;
import com.bumptech.glide.RequestManager;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class AuthActivity extends DaggerAppCompatActivity {

    private static final String TAG = "AuthActivity";
    private AuthViewModel viewModel;
    private EditText userId;
    private Button loginButton;
    private ProgressBar progressBar;

    @Inject
    ViewModelProvidersFactory providersFactory;

    @Inject
    Drawable logo;

    @Inject
    RequestManager requestManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        userId = findViewById(R.id.user_id_input);
        loginButton = findViewById(R.id.login_button);
        progressBar = findViewById(R.id.progress_bar);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attemptLogin();
            }
        });
        viewModel = ViewModelProviders.of(this, providersFactory).get(AuthViewModel.class);
        setLogo();
        subscribeObservers();
    }

    private void attemptLogin() {
        if (TextUtils.isEmpty(userId.getText().toString())){
            return;
        }
        viewModel.authenticationWithId(Integer.parseInt(userId.getText().toString()));
    }

    private void subscribeObservers(){
        viewModel.observeUser().observe(this, new Observer<AuthResource<User>>() {
            @Override
            public void onChanged(AuthResource<User> userAuthResource) {
                if (userAuthResource != null) {
                    switch (userAuthResource.status) {
                        case AUTHENTICATED:
                            showProgressBar(false);
                            Log.d(TAG, "onChanged: login success "+userAuthResource.data.getEmail());
                            break;
                        case ERROR:
                            showProgressBar(false);
                            Toast.makeText(AuthActivity.this, userAuthResource.message+"\n\n Did you enter valid user id between 1 and 10", Toast.LENGTH_LONG).show();
                            break;
                        case LOADING:
                            showProgressBar(true);
                            break;
                        case NOT_AUTHENTICATED:
                            showProgressBar(false);
                            break;
                    }
                }
            }
        });
    }

    private void showProgressBar(boolean isVisible){
        if (isVisible){
            progressBar.setVisibility(View.VISIBLE);
        }else{
            progressBar.setVisibility(View.GONE);
        }
    }

    private void setLogo(){
        requestManager
                .load(logo)
                .into((ImageView) findViewById(R.id.login_logo));
    }
}
