    package com.example.mozart.validationapplication;

    import android.app.Activity;
    import android.content.Intent;
    import android.support.v7.app.AppCompatActivity;
    import android.os.Bundle;
    import android.widget.EditText;

    public class CadastroUsuarioActivit extends Activity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_cadastro_usuario);
        }

       public static boolean testeEmail (String emailTeste) {

           if (emailTeste == null) {
               return false;
           } else {
               return android.util.patterns.EMAIL_ADDRESS.matcher(emailTeste).matcher();
           }
       }
    }
     