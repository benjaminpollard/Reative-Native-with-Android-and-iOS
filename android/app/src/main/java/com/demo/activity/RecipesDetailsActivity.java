package com.demo.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.facebook.react.ReactActivity;
import com.facebook.react.ReactActivityDelegate;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.devsupport.interfaces.DevOptionHandler;
import com.facebook.react.devsupport.interfaces.DevSupportManager;

public class RecipesDetailsActivity extends ReactActivity {
    public static final String KEY = "key1";
    private Bundle mInitialProps = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bundle bundle = this.getIntent().getExtras();
        if (bundle != null && bundle.containsKey(KEY)) {
            mInitialProps = new Bundle();
            mInitialProps.putString(KEY, bundle.getString(KEY));
        }
        super.onCreate(savedInstanceState);
    }

    /**
     * Returns the name of the main component registered from JavaScript.
     * This is used to schedule rendering of the component.
     * Because this class overrides {@link #createReactActivityDelegate()}, we don't really need
     * to override this.
     */
    @Override
    protected String getMainComponentName() {
        return "RecipeDetailPage";
    }

    /**
     * We override to provide launch options that we can read in JavaScript (see buildType).
     */
    @Override
    protected ReactActivityDelegate createReactActivityDelegate() {
        return new ReactActivityDelegate(this, getMainComponentName()) {
            @Override
            protected Bundle getLaunchOptions() {
                Bundle launchOptions = new Bundle();
                launchOptions.putString("buildType", BuildConfig.BUILD_TYPE);
                launchOptions.putString(KEY, getIntent().getStringExtra(KEY));
                return launchOptions;
            }
        };
    }


}
