package com.example.keremkuecuek.scantestespresso;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;



import java.io.File;


public class MainActivity extends AppCompatActivity {

    private Button btnScan;
    private TextView txtInfo;
    private ProgressBar progressBar;
    private int progressstatus = 0;
    private Handler mHandler = new Handler();





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnScan = findViewById(R.id.btnScan);
        txtInfo = findViewById(R.id.txtInfo);
        progressBar = findViewById(R.id.progressBar);

        checkPermission();



        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnClick();
                txtInfo.setText("Scanning");
            }
        });

    }




    private void checkPermission() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {//Can add more as per requirement

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE},
                    123);

        } else {

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults)
    {
        switch (requestCode) {
            case 123: {


                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED)     {
                    //Peform your task here if any
                } else {

                    checkPermission();
                }
                return;
            }
        }
    }


    public void btnClick() {
        File f = new File (Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS ) + "/GData_InternalTestApp_tet_0x40_cloud_apk.apk");
        //("\\storage\\emulated\\0\\Download\\GData_InternalTestApp_tet_0x40_cloud_apk.apk");

         if (f.exists()) {

        progress();


         } else {
            Toast.makeText(this, "Error: File not found", Toast.LENGTH_LONG).show();
        }
    }

    public void progress(){

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (progressstatus < 100){
                    progressstatus++;
                    android.os.SystemClock.sleep(100);
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setProgress(progressstatus);
                        }
                    });
                }
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {

                        txtInfo.setText("Virus found");
                    }
                });
            }
        }).start();

    }

}



