package com.example.luiseps.appnote;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText eExpo,ePrac,eProy,eNotafinal;
    Button bCalcular,bLimpiar;
    float pproy ,pexpo,pprac;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eExpo = (EditText) findViewById(R.id.eExpo);
        ePrac = (EditText) findViewById(R.id.ePrac);
        eProy = (EditText) findViewById(R.id.eProy);
        eNotafinal=(EditText) findViewById(R.id.eNota);
        bCalcular= (Button) findViewById(R.id.bCalc);
        bLimpiar= (Button) findViewById(R.id.bLimpiar);

        bCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double exp,prac,pro,nfinal;
                String expo,pra,proy;
                expo=eExpo.getText().toString();
                pra=ePrac.getText().toString();
                proy=eProy.getText().toString();
                if(((expo.equals(""))||(pra.equals(""))||(proy.equals("")))){
                    Toast.makeText(MainActivity.this, "Por favor ingresar todas las notas", Toast.LENGTH_SHORT).show();
                }
                else {
                    exp = Double.parseDouble(eExpo.getText().toString());
                    prac = Double.parseDouble(ePrac.getText().toString());
                    pro = Double.parseDouble(eProy.getText().toString());

                    if ((exp <= 5) && (prac <= 5) && (pro <= 5)){
                        nfinal = exp * pexpo + prac * pprac + pro *pproy;
                        eNotafinal.setText(String.valueOf(nfinal));
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Las notas deben ser menores que 5", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        bLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eExpo.setText("");
                ePrac.setText("");
                eProy.setText("");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(id == R.id.menu_configurar){
            Toast.makeText(this, "Ha presionado opcion configurar", Toast.LENGTH_SHORT).show();
            Intent i=new Intent(this,settings.class);
            i.putExtra("pProy",35);
            i.putExtra("pExpo",15);
            i.putExtra("pPrac",50);
            startActivityForResult(i,1234);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==1234 && resultCode==RESULT_OK){
            String proy,prac,expo;
            proy= data.getExtras().getString("prPro");
            expo= data.getExtras().getString("prExpo");
            prac= data.getExtras().getString("prPra");
            pprac = Float.parseFloat(prac);
            pproy = Float.parseFloat(proy);
            pexpo = Float.parseFloat(expo);


            Toast.makeText(this, "Proyecto = " +proy+ "Exposicion =" +expo+ "Practicas = " +prac, Toast.LENGTH_SHORT).show();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
