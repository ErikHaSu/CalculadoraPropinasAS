package com.example.propinas;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    EditText edtCantidad;
    Button btnCalular;
    TextView txtPorcentaje;
    TextView txtPropina;
    TextView txtTotal;
    Editable cantidad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtCantidad = (EditText)this.findViewById(R.id.cantidad);
        btnCalular = (Button) this.findViewById(R.id.calcular);
        txtPorcentaje = (TextView)this.findViewById(R.id.porcentaje);
        txtPropina = (TextView)this.findViewById(R.id.propina);
        txtTotal = (TextView)this.findViewById(R.id.total);

        Toolbar menu = (Toolbar) findViewById(R.id.menu);
        setSupportActionBar(menu);

    }
    public void onClick(View view){
        calcularPropina();
    }
    public void calcularPropina(){
        obtenerPropina();
        SharedPreferences preferencias = this.getSharedPreferences("AppPreferences", MODE_PRIVATE);
        String porcentaje = preferencias.getString("porcentajePropina", "10.0");

        double pors = Double.parseDouble(porcentaje) /100;
        double cantidad = Double.parseDouble(edtCantidad.getText().toString());
        double propina =  pors * cantidad;
        double edts = cantidad + propina;


        String prop = propina + "";
        String total = edts + "";
        txtPropina.setText(prop);
        txtTotal.setText(total);
        txtPorcentaje.setText("%"+porcentaje);

    }
    public void obtenerPropina() {
        SharedPreferences preferencias = this.getSharedPreferences("AppPreferences", MODE_PRIVATE);
        String porcentaje = preferencias.getString("porcentajePropina", "10.0");
        txtPorcentaje.setText(String.format("%s%%", porcentaje));
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.configuracion:
                this.empezarConfiguracion();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private void empezarConfiguracion(){
        Intent i = new Intent(getBaseContext(), ConfigAct.class);
        startActivity(i);
    }

    public boolean onCreateOptionsMenu (Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
