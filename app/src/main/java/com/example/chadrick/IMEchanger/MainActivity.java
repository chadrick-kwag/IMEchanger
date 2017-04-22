package com.example.chadrick.IMEchanger;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.inputmethodservice.InputMethodService;
import android.os.IBinder;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button thebutton;
    private Button notifbtn;
    public Intent intent;
    public NotificationManager notificationManager;
    public Notification n;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        thebutton = (Button) findViewById(R.id.button);
        notifbtn = (Button) findViewById(R.id.notifbtn);



        intent = new Intent(this, launchwindow.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, (int) System.currentTimeMillis(), intent ,0);


        notificationManager = (NotificationManager) getApplicationContext().getSystemService(NOTIFICATION_SERVICE);
        n = new Notification.Builder(getApplicationContext())
                .setContentTitle("content title")
                .setContentText("content text")
                .setSmallIcon(R.drawable.ic_stat_name)
                .setAutoCancel(false)
                .addAction(R.drawable.ic_stat_name,"gofor",pIntent)
                .build();

        n.flags |= Notification.FLAG_NO_CLEAR;




        thebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager imeManager = (InputMethodManager) getApplicationContext().getSystemService(INPUT_METHOD_SERVICE);
                if(imeManager!=null){
                    imeManager.showInputMethodPicker();
                    List<InputMethodInfo> list1 = imeManager.getEnabledInputMethodList();
                    InputMethodInfo item = list1.get(0);

                    System.out.println(list1);

                }else{
                    System.out.println("imeManager null");
                }
            }
        });


        notifbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                notificationManager.notify(0,n);

                System.out.println("end of notif");
            }
        });



    }


}
