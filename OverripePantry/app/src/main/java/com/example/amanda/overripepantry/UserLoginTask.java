package com.example.amanda.overripepantry;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.widget.Toast;

/**
 * http://stackoverflow.com/questions/18583386/start-mainactivity-if-user-login-sucesses
 * Created by amanda on 3/23/17.
 */
@TargetApi(13)
public class UserLoginTask extends AsyncTask<String, Void, Boolean> {

    private static final String LOG_TAG = "UserLoginTask";

    private Activity mActivity;

    public UserLoginTask(Activity activity) {
        mActivity = activity;
    }

    private void showToast(final String message) {
        mActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(mActivity, message, Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected Boolean doInBackground(String... params)  {
        if (params.length != 2) {
            Log.e(LOG_TAG, "UserLoginTask requires username and password as parameters.");
            throw new IllegalArgumentException("UserLoginTask requires username and password as parameters.");
        }

        String username = params[0];
        String password = params[1];

        showToast("Login failed - please check your username and password.");

        return null;
    }


    protected void onPostExecute(final String token) {
        if (token != null) {
            showToast("Login Successful");
            onComplete();
        } else {
            onError();
        }
    }

    protected void onComplete() {
        Intent mainActivityIntent = NavUtils.getParentActivityIntent(mActivity);
        if (mainActivityIntent != null) {
            mActivity.startActivity(mainActivityIntent);
        }
        mActivity.finish();

        return;
    }

    protected void onError() {
        return;
    }
}
