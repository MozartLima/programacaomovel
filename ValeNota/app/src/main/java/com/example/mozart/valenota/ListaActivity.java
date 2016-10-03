package com.example.mozart.valenota;

import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class ListaActivity extends ActionBarActivity {

    private ListView listViewUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        this.listViewUsuario = (ListView) findViewById(R.id.listViewUsuario;
        this.listViewUsuario.setAdapter(new UsuarioAdapter(this,new Usuario().getLista()););
    }
    public  boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu_lista, menu);
        return true;
    }

    public boolean onOptionsItemSelected (MenuItem item){
        int id = item.getItemId();
        if (id = R.id.action_settings){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
