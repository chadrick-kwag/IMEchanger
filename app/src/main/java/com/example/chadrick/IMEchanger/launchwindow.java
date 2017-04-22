package com.example.chadrick.IMEchanger;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;

import java.util.List;

/**
 * Created by chadrick on 2017-04-22.
 */

public class launchwindow extends Activity {


    private int state;
    private final String TAG = "launchwindow";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);


        state=0;

        System.out.println("inside launchwindow");
        Log.d("launchwindow","on create");

        InputMethodManager imeManager = (InputMethodManager) getApplicationContext().getSystemService(INPUT_METHOD_SERVICE);
        if(imeManager!=null){
            imeManager.showInputMethodPicker();
            state=1;


        }else{
            System.out.println("imeManager null");
        }


//        System.out.println("wfwfwfwfwfwwffwfwfwfw");


    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus){
        super.onWindowFocusChanged(hasFocus);
        Log.d("launchwindow","on window focus changed");

        if(state==1){
            Log.d(TAG,"status back to 1");
            this.finish();
        }

    }




}
