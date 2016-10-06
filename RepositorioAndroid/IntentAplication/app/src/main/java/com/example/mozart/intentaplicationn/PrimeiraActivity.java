package com.example.mozart.intentaplicationn;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;



public class PrimeiraActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState) ;
        setContentView(R.layout.activity_primeira) ;
    }

    public void clicando (View view) {

        EditText nome = (EditText) findViewById(R.id.nomeEditText);
        String info = nome.getText().toString();

        Bundle bundle = new Bundle();
        bundle.putString("nome", info);

        Log.i("Logcat", info);

        Toast.makeText(getApplicationContext(), info, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, SegundaActivity.class);
        intent.putExtras(bundle);

        startActivity(intent);


    }
}
