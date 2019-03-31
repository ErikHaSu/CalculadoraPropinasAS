package com.example.propinas;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ConfigAct extends AppCompatActivity {
    EditText EdtPorcentaje;
    Button BtnPorcentaje;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        EdtPorcentaje = (EditText) this.findViewById(R.id.editText);
        BtnPorcentaje = (Button) this.findViewById(R.id.edit_button);
        textView = (TextView) this.findViewById(R.id.textView);

        BtnPorcentaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {
                guardarPropina();
            }
        });
    }
    protected void guardarPropina(){
        SharedPreferences preferences =
                this.getSharedPreferences("AppPreferences", MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = preferences.edit();
        String porcent = EdtPorcentaje.getText().toString();
        prefEditor.putString("porcentajePropina", porcent);
        prefEditor.commit();
        this.finish();
    }
}
