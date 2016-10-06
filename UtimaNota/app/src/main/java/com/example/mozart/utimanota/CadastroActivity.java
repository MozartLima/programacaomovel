package com.example.mozart.utimanota;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class CadastroActivity extends Activity AsyncTask<usuario, Void, String> {

    @Override
        protected void onPreExecute() {
                super.onPreExecute();
            }

                @Override
        protected String doInBackground(ListaActivity... lista) {
                try {
                                Gson gson = new Gson();
                        String listaJson = gson.toJson(lista[0]);

                                Log.i("Main", listaJson);
                                        URL url = new URL("http://ladoss.info:8773/Convite_SERVICE/convidado");
                        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                        urlConnection.setRequestMethod("POST");
                        urlConnection.setRequestProperty("Content-Type", "application/json");
                        urlConnection.connect();

                                        DataOutputStream wr = new DataOutputStream(
                                        urlConnection.getOutputStream());

                                wr.writeBytes(listaJson);
                        wr.close();

                            } catch (IOException e) {
                                Log.e("Cadastrarlista", e.getMessage());
                            }
                return null;
            }
                @Override
        protected void onPostExecute(String s) {
                super.onPostExecute(s);
            }
    }