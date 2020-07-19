package com.mobile.dev.hasarel.myfarmer.Activity.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.mobile.dev.hasarel.myfarmer.Common.BaseActivity;
import com.mobile.dev.hasarel.myfarmer.R;

public class GlobalSearchActivity extends BaseActivity {

    // constants
    private static final String TAG = GlobalSearchActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_global_search);

        setToolbar(getResources().getString(R.string.global_search_activity_title), GlobalSearchActivity.this);
        setDrawer();
    }
}