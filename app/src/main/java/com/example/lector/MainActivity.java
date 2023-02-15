package com.example.lector;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity {
Button n1;
TextView f1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        n1 = (Button) findViewById(R.id.btscaner);
        f1 = (TextView) findViewById(R.id.etcodigo);
        n1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                escanner();
            }
        });
    }
    void  escanner(){
        IntentIntegrator intregador= new IntentIntegrator( MainActivity.this);
        intregador.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
        intregador.setPrompt("81");
        intregador.setCameraId(0);
        intregador.setBeepEnabled(true);
        intregador.setBarcodeImageEnabled(true);
        intregador.initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IntentResult resultado=IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if(resultado != null){
            if(resultado.getContents()==null){
                Toast.makeText(this,"lesctura canselar ",Toast.LENGTH_LONG).show();
            }
            else{
                f1.setText(resultado.getContents());
            }

        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}