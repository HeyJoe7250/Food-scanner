package com.example.foodscanner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class HomePage extends AppCompatActivity {

    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    //private List<String> favorites; //Change the list to be the list of favorites items
    Button search, saved;
    ImageButton close;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        search = findViewById(R.id.scan);
        saved = findViewById(R.id.saved);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBarScan();
            }
        });
        saved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fav();
            }
        });
    }

    public void openBarScan(){
        Intent barScan = new Intent(this, MainActivity.class);
        startActivity(barScan);
    }

    public void fav(){
        dialogBuilder = new AlertDialog.Builder(this);
        final View popupView = getLayoutInflater().inflate(R.layout.favorites, null);
        close = popupView.findViewById(R.id.close);

        dialogBuilder.setView(popupView);
        dialog = dialogBuilder.create();
        dialog.show();
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });


    }
}