package com.example.mozart.valenota;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
     Public boolean onCreateOptionsMenu(Menu menu){
       getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }
    Public boolean onOptionsItemSelected(Menu Item item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
        public void abrenovo (View view){
            Intent intent = new Intent(this,NovaActivity.class);
        startActivity(intent);
    }
    public void abrelista (View view){
        Intent intent = new Intent(this,ListActivity.class);
        startActivity(intent);
    }

}
