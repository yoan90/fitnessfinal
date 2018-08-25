package com.example.gener.fit_app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Muscles extends AppCompatActivity{
    private TextView tv_name;
    private RecyclerView recyclerView;
    private List<Muscles_struct> muss = new ArrayList<>();

    public static final String MUS = "com.octip.cours.MUSCLES";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_muscles);
        tv_name = (TextView) findViewById(R.id.tv_name);
        Intent intent = new Intent(this, MyIntentService_getMuscles.class);
        startService(intent);



try
{
    String contentFile = readFile("muscles.txt");
    JSONObject jsonObject = new JSONObject(contentFile);

    JSONArray ja = jsonObject.getJSONArray("results");

    for(int i = 0;i < ja.length();i++)
    {
        JSONObject jo = (JSONObject) ja.get(i);
        muss.add(new Muscles_struct(jo.getString("name"), jo.getString("id")));
    }
}
catch(JSONException e)
{
    e.printStackTrace();
}

        recyclerView = findViewById(R.id.recycler_muscles);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MusclesAdapter(this, muss));

    }
/*
    class Details_update extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
           String contentFile = readFile("muscles.txt");
            Log.d("before","fonctionne");
            try {
                JSONObject jsonObject = new JSONObject(contentFile);
                //tv_name.setText(jsonObject.getString("name"));



            } catch (JSONException e) {
                e.printStackTrace();
            }

            Log.d("test","test");
        }
    }
*/


    public String readFile(String file)
    {
        String text = "";

        try {
            FileInputStream fis = openFileInput(file);
            int size = fis.available();
            byte[] buffer = new byte[size];
            fis.read(buffer);
            fis.close();
            text = new String(buffer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return text;
    }


}
