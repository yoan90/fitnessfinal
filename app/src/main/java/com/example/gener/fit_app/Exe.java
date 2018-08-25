package com.example.gener.fit_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Exe extends AppCompatActivity {

    private List<Exe_struct> exetest = new ArrayList<>();
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exe);
        Intent intent = new Intent(this, MyIntentService_getExercice.class);
        startService(intent);


        exetest.add(new Exe_struct("Biceps","permet de je ene sais pas"));
        exetest.add(new Exe_struct("Biceps","permet de je ene sais pas"));
        exetest.add(new Exe_struct("Biceps","permet de je ene sais pas"));
        exetest.add(new Exe_struct("Biceps","permet de je ene sais pas"));
        String id_muscle = getIntent().getStringExtra("id");

        try
        {
            String contentFile = readFile("exercice.txt");
            JSONObject jsonObject = new JSONObject(contentFile);

            



        }
        catch(JSONException e)
        {
            e.printStackTrace();
        }



        recyclerView = findViewById(R.id.recycler_exe);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ExeAdapter(this, exetest));
    }


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