package com.newnius.util;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.apache.log4j.Level;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import de.mindpipe.android.logging.log4j.LogConfigurator;

/*
* demo
*
* */
public class MainActivity extends AppCompatActivity {
    private Button btn;
    private TextView status;
    private TextView response;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configureLogger();


        btn = (Button)findViewById(R.id.btn);
        status = (TextView)findViewById(R.id.status);
        response = (TextView)findViewById(R.id.response);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CRWhatToDo whatToDo = new CRWhatToDo() {
                    @Override
                    public CRMsg doThis() {
                        try {
                            String appid = "portal";
                            String userName = "00446070";
                            String password = "19841024";
                            CRSpider spider = new CRSpider("https://iaaa.pku.edu.cn/iaaa/oauthlogin.do");
                            Map<String, String> params = new HashMap<>();
                            params.put("appid", appid);
                            params.put("userName", userName);
                            params.put("password", password);
                            spider.setFollowRedirects(false);
                            return spider.doPost(params);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            return null;
                        }
                    }
                };

                CRCallback callback = new CRCallback() {
                    @Override
                    public void callback(CRMsg msg) {
                        status.setText("Finished");
                        response.setText(msg.get("response"));
                    }
                };

                status.setText("Runnning");
                new CRBackgroundTask(whatToDo, callback).doInBackground();
            }

        });

    }

    public void configureLogger(){
        LogConfigurator logConfigurator = new LogConfigurator();
        Date now = new Date();
        String formattedNow = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).format(now);
        logConfigurator.setInternalDebugging(false);
        logConfigurator.setFileName(Environment.getExternalStorageDirectory().toString() + File.separator + "CRLogger/log/" + formattedNow + ".log");
        logConfigurator.setRootLevel(Level.INFO);
        logConfigurator.setLevel("org.apache", Level.ERROR);
        logConfigurator.setUseFileAppender(true);
        logConfigurator.setFilePattern("%d %-5p [%c{2}]-[%L] %m%n");
        logConfigurator.setMaxFileSize(1024 * 1024 * 5);
        logConfigurator.setImmediateFlush(true);
        CRLogger.init(logConfigurator);
    }
 }
