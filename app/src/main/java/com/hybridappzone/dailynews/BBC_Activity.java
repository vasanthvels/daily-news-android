package com.hybridappzone.dailynews;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class BBC_Activity extends Activity {

    private static final String tag = BBC_Activity.class.getSimpleName();
    private static final String url = "https://newsapi.org/v1/articles?source=bbc-news&sortBy=top&apiKey=60845d03396c4771a925262ee9e30f4f";
    private List<NewsData> list = new ArrayList<NewsData>();
    private ListView listView;
    private NewsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bbc_main);

        listView = (ListView) findViewById(R.id.list);
        adapter = new NewsAdapter(this, list);
        listView.setAdapter(adapter);

        JsonObjectRequest passReq = new JsonObjectRequest(url,null,

                new Response.Listener<JSONObject>() {
                    @Override

                    public void onResponse(JSONObject response)
                    {

                        try {

                            JSONArray jsonArray= response.getJSONArray("articles");

                            int n = jsonArray.length();
                            for (int i = 0; i < n; i++) {

                                JSONObject newsObject = jsonArray.getJSONObject(i);

                                NewsData dataSet = new NewsData();

                                dataSet.setAuthor(newsObject.getString("author"));
                                dataSet.setTitle(newsObject.getString("title"));
                                dataSet.setDescription(newsObject.getString("description"));
                                dataSet.setPublishedAt(newsObject.getString("publishedAt"));
                                dataSet.setUrlToImage(newsObject.getString("urlToImage"));

                                list.add(dataSet);
                            }
                        } catch (JSONException e) {
                            Toast.makeText(getApplicationContext(), "Not available", Toast.LENGTH_SHORT).show();
                            e.printStackTrace();
                        }

                        adapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.e("Error: ", error.getMessage());
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(passReq);
        //Controller.getPermission().addToRequestQueue(billionaireReq);
    }

}
