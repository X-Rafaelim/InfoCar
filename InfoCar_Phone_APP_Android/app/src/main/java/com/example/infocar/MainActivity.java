package com.example.infocar;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button button;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT_WATCH)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //botão para fazer ir para a página das marcas
        button = (Button) findViewById(R.id.button_brands);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                brands();
            }
            });


    }

    //fuction para para o botão
    public void brands(){
        Intent intent = new Intent(this, brands.class);
        startActivity(intent);
    }


}