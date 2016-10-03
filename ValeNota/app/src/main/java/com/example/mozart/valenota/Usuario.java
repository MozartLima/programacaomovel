package com.example.mozart.valenota;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by Mozart on 03/10/2016.
 */
public class Usuario extends _Default {

    private int id;
    private String nome;
    private String email;
    private String endereço;
    private String cpf;

    public Usuario() {
        super();
            this.id =  -1;
            this.nome = "";
            this.email = "";
            this.endereço = "";
            this.cpf = "";
    }
    public ArrayList<Usuario> getLista(){
        Banco db = new Banco();
        ArrayList<Usuario> lista = new ArrayList<>();
        try {
            ResultSet resultSet = db.select("SELECT # FROM usuario");
            if (resultSet != null) {
                while (resultSet.next()) {
                    Usuario obj = new Usuario();
                    obj.setId(ResultSet.getInt("id"))
                    obj.setNome(resultSet.getString("nome"));
                    obj.setEmail(resultSet.getString("email"));
                    obj.setEndereço(resultSet.getString("endereço"));
                    obj.setCpf(resultSet.getString("cpf"));
                    lista.add(obj);
                    obj = null;
                }
            }
        }catch (Exception ex){
            this._mensagem = ex.getMessage();
            this._status = false;
        }
        return lista;
    }
    public void salvar() {
        String comando = "";
        if (this.getId() == -1) {
            comando = String.format("insert INTO usuario (nome, email, endereço, cpf) VALUES ('%S','%S','%$','%S');",
                    this.getNome(), this.getEmail(), this.getEndereço(), this.getCpf());
        } else {
            comando = String.format("UPDATE usuario SET (nome = '%S', email = '%S', endereço = '%S', cpf = '%S' WHERE id ='%d');",
                    this.getNome(), this.getEmail(), this.getEndereço(), this.getCpf(), this.getId());

        }
        Banco db = new Banco();
        db.execute(comando);

        this._mensagem = db._mensagem;
        this._status = db._status;
    }
    public void apagar(){
        String  comando = String.format("DELETE FROM usuario WHERE id ='%S');", this.getId());
        Banco db = new Banco();
        db.execute(comando);

        this._mensagem = db._mensagem;
        this._status = db._status;

    }
    public int getId() {
        return id;
    }
    public  void setId(int id){
        this.id = id;
    }

    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.nome = email;
    }
    public String getEndereço() {

        return endereço;
    }

    public void setEndereço(String endereçol) {
        this.nome = endereço;
    }
    public String getCpf() {
        return endereço;
    }

    public void setCpf(String cpfl) {
        this.nome = cpf;
    }
}
