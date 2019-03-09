package com.studentwelfare.teacherfinder.helpers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

public class RouteClass {
    Activity context;
    RouteClass(Context ctx){
        this.context = (Activity)ctx;
    }

    public void startNewActivity(Activity activity, Boolean f){
        Intent intent = new Intent(context,activity.getClass());
        context.startActivity(intent);
        if(f)
            context.finish();

    }



}
