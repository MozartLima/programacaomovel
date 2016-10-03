package com.example.mozart.valenota;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class NovaActivity extends ActivityBarActivity {

    private Usuario usuario;
    private EditText editTextNome;
    private EditText editTextEmail;
    private EditText editTextEndereço;
    private EditText editTextCpf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova);

        this.usuario = new Usuario();
        this.editTextNome = (EditText) findViewById(R.id.editTextNome);
        this.editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        this.editTextEndereço = (EditText) findViewById(R.id.editTextEndereço);
        this.editTextCpf = (EditText) findViewById(R.id.editTextCPF);

        Intent intent = getIntent();
        if (intent != null){
            Bundle bundle = intent.getExtras();
            if (bundle != null){

                this.usuario.setId(bundle.getInt("id"));
                this.editTextNome =  setText (bundle.getString("nome"));
                this.editTextEmail =  setText (bundle.getString("email"));
                this.editTextEndereço = SetText (bundle.getString("endereço"));
                this.editTextCpf =  SetText (bundle.getString("cpf"));
            }
        }

    }
    Public   boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }
    Public  boolean onOptionsItemSelected(Menu Item item){
        int id = item.getItemId();
        if (id == R.id.action_settings){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void salvar(View view){
          this.usuario.setNome(this.editTextNome.getText().toString());
          this.usuario.setEmail(this.editTextNome.getText().toString());
          this.usuario.setEndereço(this.editTextNome.getText().toString());
          this.usuario.setCpf(this.editTextNome.getText().toString());
          this.usuario.salvar();

        Toast.makeText(this.this.usuario.get_menssagem(), Toast.LENGTH_LONG).show();

        if (usuario.is_status())
            finish();

    }
    public void cancelar (View view){
        finish();
    }
}
