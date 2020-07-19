package com.mobile.dev.hasarel.myfarmer.Common;

import androidx.appcompat.app.AlertDialog;
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

import com.mobile.dev.hasarel.myfarmer.Activity.Activities.AboutActivity;
import com.mobile.dev.hasarel.myfarmer.Activity.Activities.GlobalSearchActivity;
import com.mobile.dev.hasarel.myfarmer.Activity.Activities.HomeActivity;
import com.mobile.dev.hasarel.myfarmer.Activity.Activities.LoginActivity;
import com.mobile.dev.hasarel.myfarmer.Activity.Activities.SettingsActivity;
import com.mobile.dev.hasarel.myfarmer.Activity.Fragment.DrawerFragment;
import com.mobile.dev.hasarel.myfarmer.R;
import com.mobile.dev.hasarel.myfarmer.Utill.AppUtill;

public class BaseActivity extends AppCompatActivity implements DrawerFragment.FragmentDrawerListener {

    // constants
    private static final String TAG = BaseActivity.class.getSimpleName();

    private Toolbar mToolbar;
    private DrawerFragment mDrawerFragment;
    private DrawerLayout mDrawerLayout;

    public BaseActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void setToolbar(String toolbarName, Activity activity) {
        mToolbar = findViewById(R.id.toolbar);
        mToolbar.setTitle("");
        TextView tvTitle = findViewById(R.id.tv_toolbar_title);
        tvTitle.setText(toolbarName);
        if (toolbarName.isEmpty()) {
            // mToolbar.setBackgroundColor(Color.TRANSPARENT);
        }
        setSupportActionBar(mToolbar);
        if (!activity.getClass().getSimpleName().equals(HomeActivity.class.getSimpleName())) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        //set custom navigation icon
        /*getSupportActionBar().setHomeAsUpIndicator(AppUtil.getDrawable(Iconify.IconValue.arrow_left,
                ContextCompat.getColor(this, R.color.color_toolbar_icon_white), this, 34));*/
    }

    public void setDrawer() {
        mDrawerLayout = findViewById(R.id.drawer_layout);

        mDrawerFragment = (DrawerFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        mDrawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        mDrawerFragment.setDrawerListener(this);
    }

    @Override
    public void onDrawerItemSelected(int position) {
        displayView(this, position);
    }

    private void displayView(final Activity activity, int position) {
        switch (position) {
            case 0: // Dashboard (MainActivity)
                if (!activity.getClass().getSimpleName().equals(HomeActivity.class.getSimpleName())) {
                    activity.finish();
                    activity.overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
                }
                break;
            case 1: // Global Search (GlobalSearchActivity)
                if (!activity.getClass().getSimpleName().equals(GlobalSearchActivity.class.getSimpleName())) {
                    AppUtill.startActivityFromDrawer(activity, GlobalSearchActivity.class);
                }
                break;
            case 2: // Sync (Sync Activity)
                if (!activity.getClass().getSimpleName().equals(SettingsActivity.class.getSimpleName())) {
                    AppUtill.startActivityFromDrawer(activity, SettingsActivity.class);
                }
                break;
            case 3: // About (About Activity)
                if (!activity.getClass().getSimpleName().equals(AboutActivity.class.getSimpleName())) {
                    AppUtill.startActivityFromDrawer(activity, AboutActivity.class);
                }
                break;
            case 4:// Logout
                final Activity innerActivity = activity;
                final AlertDialog dialog = new AlertDialog.Builder(activity).create();
                AppUtill.showCustomConfirmAlert(dialog, activity, getResources().getString(R.string.sign_out_text), getResources().getString(R.string.sign_out_message),

                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog.dismiss();
                                Toast.makeText(innerActivity, getResources().getText(R.string.nav_item_logout), Toast.LENGTH_SHORT).show();

                        /*innerActivity.finish();
                        AppUtil.startActivity(innerActivity, LoginActivity.class);*/
                                startActivity(new Intent(getApplicationContext(), LoginActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));
                            }
                        }, null, getResources().getString(R.string.yes_text), getResources().getString(R.string.no_text), false);
                break;
            default:
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout != null && mDrawerLayout.isDrawerOpen(Gravity.LEFT)) {
            mDrawerLayout.closeDrawer(Gravity.LEFT);
        } else {
            super.onBackPressed();
            overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
        }
    }
}