package com.example.emergencyalert;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MyNews extends Fragment {



    public MyNews() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_my_news, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {

                URL myUrl = null;
                URLConnection myUrlConnection = null;
                InputStreamReader myInputStreamReader = null;
                BufferedReader in;

                try {
                    myUrl = new URL("https://newsapi.org/v2/top-headlines?country=us&apiKey=2ad130f782ac4c8ea47427d709022569");
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }

                try {
                    myUrlConnection = myUrl.openConnection();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                java.io.InputStream myInputStream = null;
                try {
                    myInputStream = myUrlConnection.getInputStream();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                myInputStreamReader = new InputStreamReader(myInputStream);


                in = new BufferedReader(myInputStreamReader);

                String line, str;
                str = "";

                System.out.print("\n");

                try {
                    while ((line = in.readLine()) != null)
                        str += line;
                } catch (IOException e) {
                    e.printStackTrace();
                }

                JSONObject myJsonObject = null;
                try {
                    myJsonObject = new JSONObject(str);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                JSONArray resultsArray = null;
                try {
                    resultsArray = myJsonObject.getJSONArray("articles");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                System.out.println("\nNumber of results: " + resultsArray.length());

            }
        });
    }
}
