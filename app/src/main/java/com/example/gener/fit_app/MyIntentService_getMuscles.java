package com.example.gener.fit_app;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class MyIntentService_getMuscles extends IntentService {
    private String result;

    public MyIntentService_getMuscles() {
        super("hello");
    }


    @Override
    protected void onHandleIntent(Intent intent) {
        try {
            OpenData opendata = new OpenData("https://wger.de/api/v2/muscle/?format=json");
            result = opendata.getData();

            writeToFile("muscles.txt",result);

            OpenData dataExe = new OpenData("https://wger.de/api/v2/exercise/");
            List<String> resultExe = dataExe.getDataExercice();

            StringBuffer tmp = new StringBuffer();
            for(int i = 0; i < resultExe.size();i++)
            {
                tmp.append(resultExe.get(i));
            }

            Log.d("try",tmp.toString());
            writeToFile("exercice.txt",tmp.toString());

            LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent(Muscles.MUS));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeToFile( String filename, String str) {
        try {
            FileOutputStream fos = openFileOutput(filename, Context.MODE_PRIVATE);
            fos.write(str.getBytes());
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
