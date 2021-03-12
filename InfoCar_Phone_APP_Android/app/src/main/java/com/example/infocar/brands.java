package com.example.infocar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class brands extends AppCompatActivity implements principalAdapter.OnItemClickListener {
    private RecyclerView mRecyclerView;
    private principalAdapter mAdapter;
    private ArrayList<BrandsCars> mList;
    private RequestQueue mRequestQueue;

    private Button button;

    public static int id_brand;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brands);

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mList = new ArrayList<>();

        mRequestQueue = Volley.newRequestQueue(this);
        parseJSON();


    }


    //Conecção para a API
    private void parseJSON() {


        String url = " PUT_HERE_API_LINK ";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("records");

                            JSONObject teste = jsonArray.getJSONObject(2);

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject records = jsonArray.getJSONObject(i);

                                String brand_name = records.getString("brand_name");
                                String image = records.getString("image");

                                mList.add(new BrandsCars(brand_name, image));

                            }

                            mAdapter = new principalAdapter(brands.this, mList);
                            mRecyclerView.setAdapter(mAdapter);

                            mAdapter.setOnItemClickListener(brands.this);
                        } catch (JSONException e) {
                            System.out.println(e);

                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error);

            }
        });
        mRequestQueue.add(request);
    }




    @Override
    public void onItemClick(int position) {
        Intent modelIntent = new Intent(this, models.class);
        id_brand = position + 1;
        startActivity(modelIntent);

    }
}