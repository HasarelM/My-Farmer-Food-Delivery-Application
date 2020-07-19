package com.mobile.dev.hasarel.myfarmer.Activity.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.mobile.dev.hasarel.myfarmer.Common.BaseActivity;
import com.mobile.dev.hasarel.myfarmer.R;

public class SettingsActivity extends BaseActivity {

    // constants
    private static final String TAG = SettingsActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        setToolbar(getResources().getString(R.string.sync_activity_title), SettingsActivity.this);
        setDrawer();
    }
}