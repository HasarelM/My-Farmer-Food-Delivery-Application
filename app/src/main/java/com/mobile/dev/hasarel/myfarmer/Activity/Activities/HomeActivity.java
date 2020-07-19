package com.mobile.dev.hasarel.myfarmer.Activity.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.mobile.dev.hasarel.myfarmer.Activity.Fragment.DrawerFragment;
import com.mobile.dev.hasarel.myfarmer.Common.BaseActivity;
import com.mobile.dev.hasarel.myfarmer.R;

public class HomeActivity extends BaseActivity {

    // constants
    private static final String TAG = HomeActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setToolbar(getResources().getString(R.string.main_activity_title), HomeActivity.this);
        setDrawer();
    }
}