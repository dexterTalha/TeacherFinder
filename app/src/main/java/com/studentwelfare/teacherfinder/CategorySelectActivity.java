package com.studentwelfare.teacherfinder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.studentwelfare.teacherfinder.helpers.SessionManagement;

public class CategorySelectActivity extends AppCompatActivity {

    Button bottom_btn;
    ImageView student, teacher;
    int value_select;
    RelativeLayout rel_btn_container;
    SessionManagement sessionManagement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_select);

        bottom_btn = findViewById(R.id.btn_next_select);
        student = findViewById(R.id.select_student);
        teacher = findViewById(R.id.select_teacher);
        rel_btn_container = findViewById(R.id.rel_layout_select);

        sessionManagement = new SessionManagement(this);

        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value_select = toggle(0);
                bottom_btn.setVisibility(View.VISIBLE);
                rel_btn_container.setVisibility(View.VISIBLE);
            }
        });

        teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value_select = toggle(1);
                bottom_btn.setVisibility(View.VISIBLE);
                rel_btn_container.setVisibility(View.VISIBLE);
            }
        });

        bottom_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CategorySelectActivity.this, ""+value_select, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(CategorySelectActivity.this, HomePage.class);
                intent.putExtra("gender",""+value_select);
                sessionManagement.editor.putString(SessionManagement.KEY_TYPE,""+value_select);
                sessionManagement.editor.commit();
                startActivity(intent);
                finish();
            }
        });


    }


    private int toggle(int val){
        if(val == 0){
            student.setImageDrawable(getResources().getDrawable(R.drawable.student_icon_enabled));
            teacher.setImageDrawable(getResources().getDrawable(R.drawable.teacher_icon_disabled));
            return 0;
        }else if(val == 1) {
            teacher.setImageDrawable(getResources().getDrawable(R.drawable.teacher_icon_enabled));
            student.setImageDrawable(getResources().getDrawable(R.drawable.student_icon_disabled));
            return 1;
        }
        return 0;
    }

}
