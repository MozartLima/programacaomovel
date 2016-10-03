package com.example.mozart.valenota;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 * Created by Mozart on 03/10/2016.
 */
public class Banco extends _Default implements Runnable {

    private Connection conn;
    //192.168.146.2 minha maquina
    private String host = "192.168.146.2";
    private String db = "";
    private int port = 5555;
    private String user = "?????";
    private String pass = "?????";

    // %s host, %d porta, %s database
    private String url = "jdbc:postgresql://%s:%d/%s";


    public Banco() {
        super();
        this.url = String.format(this.url, this.host, this.port, this.db);
        this.conecta();
        this.disconecta();
    }
 // metodo para conectar o banco de dados
    @Override
    public void run() {
        try {
            Class.forName("org.postgresql.Driver");
            this.conn = DriverManager.getConnection(this.url, this.user, this.pass);
        }
    }

    catch(
    Exception e
    )

    {
        this._mensagem = e.getMessage();
        this._status = false;
    }

    private void conecta() {
        Thread thread = new Thread(this);
        thread.start();
        // quando der o start vai rodar o que tem no metodo run(conexão com o banco)
        try {
            // a aplicação espera a conclusão do metodo run
            thread.join();
        } catch (Exception e) {
            this._mensagem = e.getMessage();
            this._status = false;
        }
    }

    private void disconecta() {
        if (this.conn != null) {
            try {
                this.conn.close();
            } catch (Exception e) {

            } finally {
                this.conn = null;
            }
        }
    }

    public ResultSet select(String query) {
        this.conecta();
        ResultSet resultSet = null;
        try {
            resultSet = new Execute(this.conn, query).execute().get();
        } catch (Exception e) {
            this._status = false;
            this._mensagem = e.getMessage();
        }
        return  resultSet;
    }
    public ResultSet execute(String query) {
        this.conecta();
        ResultSet resultSet = null;
        try {
            resultSet = new Execute(this.conn, query).execute().get();
        } catch (Exception e) {
            this._status = false;
            this._mensagem = e.getMessage();
        }
        return  resultSet;
    }
}