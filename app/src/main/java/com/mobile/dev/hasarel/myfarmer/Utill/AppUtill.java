package com.mobile.dev.hasarel.myfarmer.Utill;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import com.mobile.dev.hasarel.myfarmer.Activity.Activities.HomeActivity;
import com.mobile.dev.hasarel.myfarmer.R;

public class AppUtill {
    public static void showCustomConfirmAlert(final AlertDialog dialog, Activity activity, String title, String message,
                                              View.OnClickListener yesClickListener, View.OnClickListener noClickListener,
                                              String yesText, String noText, boolean cancelableState) {

        LayoutInflater inflater = activity.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.dialog_custom_confirm_alert, null);
        dialogView.setLayerType(View.LAYER_TYPE_SOFTWARE, null); // This line is for hardware acceleration false
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setView(dialogView);
        dialog.setCancelable(cancelableState);

        TextView tvTitle = dialogView.findViewById(R.id.custom_alert_tv_title);
        TextView tvMessage = dialogView.findViewById(R.id.custom_alert_tv_description);
        Button btnCancel = dialogView.findViewById(R.id.custom_alert_btn_cancel);
        Button btnSettings = dialogView.findViewById(R.id.custom_alert_btn_settings);
        btnCancel.setOnClickListener(noClickListener);
        btnSettings.setOnClickListener(yesClickListener);

        if (noClickListener == null)
            btnCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });

        if (yesClickListener == null)
            btnSettings.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });

        if (title.isEmpty()) {
            tvTitle.setVisibility(View.GONE);
        } else {
            tvTitle.setText(title);
        }

        tvMessage.setText(message);
        btnCancel.setText(noText);
        btnSettings.setText(yesText);

        Display display = activity.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        Log.i("Screen Width: ", "" + width);

        /*boolean mTabletDevice = activity.getResources().getBoolean(R.bool.isTablet);

        if (mTabletDevice) {
            UiUtil.setTextViewFontSizeBasedOnScreenDensity(activity, tvTitle, 60.0, true);
            UiUtil.setTextViewFontSizeBasedOnScreenDensity(activity, tvMessage, 65.0, false);
            UiUtil.setButtonFontSizeBasedOnScreenDensity(activity, btnCancel, 63.0, Typeface.BOLD);
            UiUtil.setButtonFontSizeBasedOnScreenDensity(activity, btnSettings, 63.0, Typeface.BOLD);
        } else {
            UiUtil.setTextViewFontSizeBasedOnScreenDensity(activity, tvTitle, 22.0, true);
            UiUtil.setTextViewFontSizeBasedOnScreenDensity(activity, tvMessage, 27.0, false);
            UiUtil.setButtonFontSizeBasedOnScreenDensity(activity, btnCancel, 25.0, Typeface.BOLD);
            UiUtil.setButtonFontSizeBasedOnScreenDensity(activity, btnSettings, 25.0, Typeface.BOLD);
        }*/

        dialog.show();
        dialog.getWindow().setLayout(width - 80, WindowManager.LayoutParams.WRAP_CONTENT);
    }

    // start an activity using drawer
    public static void startActivityFromDrawer(Activity activity, Class<? extends Activity> aClass) {
        if (!activity.getClass().getSimpleName().equals(HomeActivity.class.getSimpleName()))
            activity.finish();
        Intent intent = new Intent(activity, aClass);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
    }
}
