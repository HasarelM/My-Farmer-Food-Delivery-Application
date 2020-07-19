package com.mobile.dev.hasarel.myfarmer.Activity.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.mobile.dev.hasarel.myfarmer.Common.BaseActivity;
import com.mobile.dev.hasarel.myfarmer.R;

public class AboutActivity extends BaseActivity {

    // constants
    private static final String TAG = AboutActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        setToolbar(getResources().getString(R.string.about_activity_title), AboutActivity.this);
        setDrawer();
    }
}