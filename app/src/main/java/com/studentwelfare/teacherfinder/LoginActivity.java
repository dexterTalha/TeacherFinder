package com.studentwelfare.teacherfinder;

import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Vibrator;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.studentwelfare.teacherfinder.helpers.SessionManagement;

import java.lang.reflect.Field;

public class LoginActivity extends AppCompatActivity {

    EditText ed_username, ed_password;
    TextInputLayout input_username, input_password;
    Button btnLogin;
    Vibrator vibrator;
    Animation animationShake;
    SessionManagement sessionManagement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ed_password = findViewById(R.id.ed_password);
        ed_username = findViewById(R.id.ed_username);
        input_username = findViewById(R.id.etUsernameLayout);
        input_password = findViewById(R.id.etPasswordLayout);
        btnLogin = findViewById(R.id.btn_login);
        ed_username.getBackground().mutate().setColorFilter(getResources().getColor(android.R.color.white), PorterDuff.Mode.SRC_ATOP);
        ed_password.getBackground().mutate().setColorFilter(getResources().getColor(android.R.color.white), PorterDuff.Mode.SRC_ATOP);

        sessionManagement = new SessionManagement(this);

        Field f;
        try {
            f = TextView.class.getDeclaredField("mCursorDrawableRes");
            f.setAccessible(true);
            f.set(ed_password, R.drawable.cursor);
            f.set(ed_username, R.drawable.cursor);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }


        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validateForm(ed_username, input_username) && validateForm(ed_password, input_password)) {
                    sessionManagement.editor.putString(SessionManagement.KEY_EMAIL, ed_username.getText().toString().trim());
                    sessionManagement.editor.putString(SessionManagement.KEY_PASSWORD, ed_password.getText().toString().trim());
                    sessionManagement.editor.putBoolean(SessionManagement.IS_LOGIN, true);
                    sessionManagement.editor.commit();
                    startActivity(new Intent(LoginActivity.this, CategorySelectActivity.class));
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //startActivity(new Intent(this, SplashScreen.class));
        finish();
    }



    private boolean validateForm(EditText ed, TextInputLayout inputLayout){
        //ed.requestFocus();
        animationShake = AnimationUtils.loadAnimation(LoginActivity.this, R.anim.shake_edit_text);
        if(!ed.getText().toString().trim().isEmpty()){
            return true;
        }

        inputLayout.setErrorEnabled(true);
        ed.setError("This field is required");
        inputLayout.setError("This field is required");
        vibrator.vibrate(120);
        inputLayout.setAnimation(animationShake);
        ed.setAnimation(animationShake);
        return false;
    }
}
