package com.example.mozart.utimanota;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ListaActivity extends Activity {

        private String nome;
        private String email;
        private String endereco;
        private String cpf;

                public String getNome() {
                return nome;
            }
                public void setNome(String nome) {
                this.nome = nome;
            }

                 public String getCpf() {
                return cpf;
             }

                  public void setCpf(String cpf) {
                      this.cpf = cpf;
             }

                public String getEndereco() {
                return endereco;
            }

                public void setEndereco(String endereço) {
                this.endereco = endereço;
            }


             public String getEmail() {
             return email;
    }

             public void setEmail(String email) {
             this.email = email;
    }
    }

