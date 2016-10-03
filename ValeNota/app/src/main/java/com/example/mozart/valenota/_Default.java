package com.example.mozart.valenota;

/**
 * Created by Mozart on 03/10/2016.
 */

//clsse criada porques existem campos que serão usadas em outras classe
// como a de usuário como a de conxão com o banco
public class _Default {
    // se houver alguma exeção será usados esses campos
    protected String _mensagem;
    protected boolean _status;

    public  _Default(){
        this._status = true;
        this._mensagem ="";
    }

    public String get_menssagem() {
        return _mensagem;
    }

    public void set_menssagem(String _menssagem) {
        this._mensagem = _menssagem;
    }
    public boolean  is_status() {
        return _status;
    }

    public void set_status(boolean _status) {

        this._status = _status;
    }
}
