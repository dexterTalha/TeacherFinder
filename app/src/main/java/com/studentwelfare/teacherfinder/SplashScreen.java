package com.studentwelfare.teacherfinder;

import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.studentwelfare.teacherfinder.helpers.SessionManagement;


public class SplashScreen extends AppCompatActivity {

    RelativeLayout r1;
    Button email, facebook_login, google_login;
    SessionManagement sessionManagement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash_screen);

        sessionManagement = new SessionManagement(this);

        r1 = findViewById(R.id.rellay1);
        show_options();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private void show_options() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(sessionManagement.isLoggedIn()){
                    startActivity(new Intent(SplashScreen.this, HomePage.class));
                    finish();
                }else
                    r1.setVisibility(View.VISIBLE);
            }
        },3000);
    }

    public void emialLogin(View view) {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }


}
