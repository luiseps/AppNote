package com.example.luiseps.appnote;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class settings extends AppCompatActivity {
    EditText eExp,ePra,ePro;
    Button bGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        eExp=(EditText) findViewById(R.id.eSExpo);
        ePra=(EditText) findViewById(R.id.eSPrac);
        ePro=(EditText) findViewById(R.id.eSProy);
        bGuardar= (Button) findViewById(R.id.bGuardar);

        Bundle extras = getIntent().getExtras();

        eExp.setText(String.valueOf(extras.getInt("pExpo")));
        ePro.setText(String.valueOf(extras.getInt("pProy")));
        ePra.setText(String.valueOf(extras.getInt("pPrac")));

        bGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("prPro", ePro.getText().toString());
                intent.putExtra("prExpo", eExp.getText().toString());
                intent.putExtra("prPra", ePra.getText().toString());
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}
