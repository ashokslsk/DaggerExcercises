package com.androidabcd.ashokslsk.depeinje.ui.main;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.androidabcd.ashokslsk.depeinje.BaseActivity;
import com.androidabcd.ashokslsk.depeinje.R;

public class MainActivity extends BaseActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
