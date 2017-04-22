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
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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





        intent = new Intent(this, launchwindow.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, 0 , intent ,0);


        notificationManager = (NotificationManager) getApplicationContext().getSystemService(NOTIFICATION_SERVICE);
        n = new Notification.Builder(getApplicationContext())
                .setContentTitle("IME changer")
                .setContentText("click button below to open IME picker")
                .setSmallIcon(R.drawable.ic_keyboard_white_48dp)
                .setAutoCancel(false)
                .addAction(R.drawable.ic_keyboard_arrow_right_white_48dp,"SWITCH",pIntent)
                .build();

        n.flags |= Notification.FLAG_NO_CLEAR;


        notificationManager.notify(0,n);

        /*

        set up toast with custom look
         */
        LayoutInflater inflator = getLayoutInflater();
        View customlook = inflator.inflate(R.layout.toastlayout,null);

        TextView toasttext = (TextView) customlook.findViewById(R.id.toasttext);
        toasttext.setText(R.string.toast_text);

        Toast customtoast = new Toast(getApplicationContext());

        customtoast.setView(customlook);
        customtoast.setDuration(Toast.LENGTH_SHORT);
        customtoast.show();
//
//        Toast toast = Toast.makeText(this, "IMESwitcher added!", Toast.LENGTH_SHORT);
//        View vieew = toast.getView();
//        vieew.setBackgroundResource(R.drawable.toastshape);
//        toast.setView(vieew);
//
//        toast.show();


        this.finish();

    }


}
