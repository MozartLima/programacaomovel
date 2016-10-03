        package com.example.mozart.validationapplication;

        import android.app.Activity;
        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.EditText;

        public class LoginActivity extends Activity {
            String S ="12345";
            String E ="teste@mail.com";


            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_login);
            }

            public void logando (View view){

                EditText emailEditText = (EditText) findViewById(R.id.emailLogEditText);
                String email = emailEditText.getText().toString();

                EditText senhaLogEditText = (EditText) findViewById(R.id.senhaLogEditText);
                String senha =senhaLogEditText.getText().toString();


                if (email.equals(E) && senha.equals(S)) {
                                Intent intent = new Intent(this, BoasVindas.class);
                                startActivity(intent);
                } else {
                    if (!email.equals("teste@mail.com")){
                           emailEditText.setError("Email Incorreto");}
                    if (!senha.equals("12345")){
                           senhaLogEditText.setError("Senha Incorreta");}
                            }
                    }

            public void cadastrando (View view){
                Intent intent = new Intent(this, CadastroUsuarioActivit.class);
                            startActivity(intent);
                    }
        }
