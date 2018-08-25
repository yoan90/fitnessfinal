package com.example.gener.fit_app;

import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gener on 21/08/2018.
 */

public class OpenData {
    private String url ="";
    private List<String> data = new ArrayList<>();

    public OpenData(String url)
    {
        this.url = url;
    }


    public String getData() throws Exception
    {
        String response = OkHttpUtils.sendGetOkHttpRequest(this.url);
        return response;
    }

    public List<String> getDataExercice() throws Exception
    {
        int page = 26;
        for (int i = 1;i <= page;i++)
        {
            this.data.add(OkHttpUtils.sendGetOkHttpRequest("https://wger.de/api/v2/exercise/?page="+i));
        }
        return this.data;
    }
}
