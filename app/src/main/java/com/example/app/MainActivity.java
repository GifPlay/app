package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.telephony.PhoneNumberUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myapplication.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void EnviarMensaje(View view) {
        Intent enviar = new Intent(this, Message.class);
        final EditText etSaludo = findViewById(R.id.etSaludo);
        String mensaje = etSaludo.getText().toString();
        enviar.putExtra(EXTRA_MESSAGE, mensaje);
        startActivity(enviar);
    }

    public void Llamar(View view) {
        Intent llamar = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:2311745579"));
        startActivity(llamar);
    }

    // Buscar cómo lanzar WhatsApp desde Intent
  /*  public void IniciarWhatsApp(View view){
        Intent iniciarWhatsApp = getPackageManager().getLaunchIntentForPackage("com.whatsapp");
        startActivity(iniciarWhatsApp);
    }*/

    public void IniciarWhatsApp(View view) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }


    public void sendImageWhatsApp() {
        try {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.setAction(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_STREAM, Uri.parse(Environment.getExternalStorageDirectory() + "/" + "Imagen.jpg"));
            intent.putExtra("jid", "2311504983" + "@s.whatsapp.net"); //numero telefonico sin prefijo "+"!
            intent.setPackage("com.whatsapp");
            startActivity(intent);
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getApplicationContext(), "Whatsapp no esta instalado.", Toast.LENGTH_LONG).show();
        }
    }

}