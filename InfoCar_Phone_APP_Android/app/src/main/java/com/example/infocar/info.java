package com.example.infocar;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static com.example.infocar.models.id_models;

public class info extends AppCompatActivity   {
    private RequestQueue mRequestQueue;
    Context context = null;
    String image = null;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        context = this;
        mRequestQueue = Volley.newRequestQueue(this);
        parseJSON();
    }

    private void parseJSON() {
        String url = "PUT_HERE_API_LINK ";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("information");
                            ImageView imageView = findViewById(R.id.imagem_info);

                            TextView prod_anos = findViewById(R.id.ano_prod);
                            TextView cod_motor = findViewById(R.id.cod_motor);
                            TextView comb = findViewById(R.id.comb);
                            TextView aspiration = findViewById(R.id.aspi);
                            TextView traction = findViewById(R.id.trac);
                            TextView mudancas = findViewById(R.id.mud);
                            TextView cavalos = findViewById(R.id.cava);
                            TextView velocidade_max = findViewById(R.id.vel_max);
                            TextView max_rpm = findViewById(R.id.rpm);
                            TextView tank_max = findViewById(R.id.tank);
                            TextView peso = findViewById(R.id.kg);
                            TextView portas = findViewById(R.id.port);
                            TextView consumo_comb = findViewById(R.id.cons_comb);




                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject records2 = jsonArray.getJSONObject(i);
                                int models_id = records2.getInt("models_idmodels");

                                String image = records2.getString("image");


                                if (models_id == id_models){
                                    String anos_prod= records2.getString("production_years");
                                    String motor_cod = records2.getString("engine_code");
                                    String combust = records2.getString("fuel_type");
                                    String aspi = records2.getString("aspiration");
                                    String trac = records2.getString("traction");
                                    String mud = records2.getString("gearbox");
                                    String caval = records2.getString("hp");
                                    String vel_max = records2.getString("top_speed");
                                    String rpm_max = records2.getString("max_rpm");
                                    String max_tank = records2.getString("fuel_tank_capacity");
                                    String pesoo = records2.getString("weight");
                                    String por = records2.getString("num_doors");
                                    String con_comb = records2.getString("fuel_consumption");

                                    prod_anos.setText(anos_prod);
                                    cod_motor.setText(motor_cod);
                                    comb.setText(combust);
                                    aspiration.setText(aspi);
                                    traction.setText(trac);
                                    mudancas.setText(mud);
                                    cavalos.setText(caval);
                                    velocidade_max.setText(vel_max);
                                    max_rpm.setText(rpm_max);
                                    tank_max.setText(max_tank);
                                    peso.setText(pesoo);
                                    portas.setText(por);
                                    consumo_comb.setText(con_comb);

                                    Picasso.with(context).load(image).into(imageView);
                                }
                            }
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


}