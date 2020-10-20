package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Message extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        Intent recibirDatos = getIntent();
        String mensaje = recibirDatos.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView txtContenido = findViewById(R.id.txtContenido);
        txtContenido.setText(mensaje);
    }

    public void regresar(View view) {
        Intent regresar = new Intent(this, MainActivity.class);
        startActivity(regresar);
    }

}