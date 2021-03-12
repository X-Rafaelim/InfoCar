package com.example.infocar;

import android.content.Intent;
import android.os.Bundle;

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

import static com.example.infocar.brands.id_brand;

public class models extends AppCompatActivity implements secondAdapter.OnItemClickListener  {

    private RecyclerView mRecyclerView;
    private secondAdapter mAdapter;
    private ArrayList<ModelsCars> mList;
    private RequestQueue mRequestQueue;
    private secondAdapter mAdapter2;

    public static int id_models;
    private int position2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_models);

        mRecyclerView = findViewById(R.id.recycler_view_models);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mList = new ArrayList<>();

        mRequestQueue = Volley.newRequestQueue(this);
        parseJSON();
    }


    //Conecção para a API
    private void parseJSON () {
        String url = "PUT_HERE_API_LINK ";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {;
                            JSONArray jsonArray = response.getJSONArray("records");



                            for (int i = 0; i < jsonArray.length();i++){
                                JSONObject records = jsonArray.getJSONObject(i);
                                String models ="";
                                String image = "";


                                int brand_id = records.getInt("brands_idbrands");
                                if (brand_id == id_brand){
                                models = records.getString("models");
                                image = records.getString("image");


                                mList.add(new ModelsCars(models, image));
                                mAdapter = new  secondAdapter(models.this,mList);
                                mRecyclerView.setAdapter(mAdapter);
                                }
                            }

                            mAdapter = new secondAdapter(models.this,mList);
                            mRecyclerView.setAdapter(mAdapter);
                            mAdapter.setOnItemClickListener(models.this);


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

    private void get_id_model(){

        String url = "PUT_HERE_API_LINK ";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {;
                            JSONArray jsonArray = response.getJSONArray("records");

                            JSONArray array = new JSONArray();

                            for (int i = 0; i < jsonArray.length();i++){
                                JSONObject records = jsonArray.getJSONObject(i);

                                int brand_id = records.getInt("brands_idbrands");
                                id_models = records.getInt("idmodels");
                                String teste = records.getString("models");

                                if (brand_id == id_brand){
                                    JSONObject item = new JSONObject();
                                    item.put("idmodels", id_models);
                                    item.put("brands_idbrands", brand_id);
                                    array.put(item);
                                }
                                System.out.println();
                            }

                            JSONObject records = array.getJSONObject(position2);
                            id_models = records.getInt("idmodels");

                        } catch (JSONException jsonException) {
                            jsonException.printStackTrace();
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
        Intent modelIntent = new Intent(this, info.class);
        position2 = position;
        get_id_model();
        startActivity(modelIntent);

    }
}