package com.demo.activity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.demo.activity.ReactModules.ActivityStarterModule;
import com.facebook.react.ReactActivity;

/**
 * Activity to start from React Native JavaScript, triggered via
 * {@link ActivityStarterModule#navigateToExample()}.
 */
public final class SignUpActivity extends ReactActivity {

    @Override
    @CallSuper
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);
        Glide.with(this).load("https://images.unsplash.com/photo-1490818387583-1baba5e638af?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9").into((ImageView) findViewById(R.id.imageView));


        findViewById(R.id.go_back_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SignUpActivity b = (SignUpActivity) view.getContext();
                b.startActivity(new Intent(b,MainActivity.class));
                //onBackPressed();
            }
        });

        findViewById(R.id.go_back_button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SignUpActivity b = (SignUpActivity) view.getContext();
                b.startActivity(new Intent(b,MainActivity.class));
                //onBackPressed();
            }
        });

    }
}
