package com.example.mozart.utimanota;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main  extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonCadastro = (Button) findViewById(R.id.buttonCadastrar);
                buttonCadastro.setOnClickListener(this);

        Button buttonLista = (Button) findViewById(R.id.buttonListar);
                buttonLista.setOnClickListener(this);
    }
    @Override
        public void onClick(View view) {

                EditText nomeEditText = (EditText) findViewById(R.id.nomeEditText);
                EditText emailEditText = (EditText) findViewById(R.id.emailEditText);
                EditText enderecoEditText = (EditText) findViewById(R.id.enderecoEditText);
                EditText cpfEditText = (EditText) findViewById(R.id.cpfEditText);

                        String nome = nomeEditText.getText().toString();
                        String cpf = cpfEditText.getText().toString();
                        String endereco = enderecoEditText.getText().toString();
                        String email = emailEditText.getText().toString();

                       ListaActivity lista = new ListaActivity();
                         lista.setNome(nome);
                         lista.setCpf(cpf);
                         lista.setEndereco(endereco);
                         lista.setEmail(email);

                        CadastroActivity cadastrarlista = new CadastroActivity();
                cadastrarlista.execute(lista);
            }
}
