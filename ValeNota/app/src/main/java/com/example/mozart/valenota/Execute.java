package com.example.mozart.valenota;

import java.sql.Connection;
import java.sql.ResultSet;

import javax.xml.transform.Result;

/**
 * Created by Mozart on 03/10/2016.
 */
//classe para iserir, deletar no banco e retornar o result set
public class Execute extends AsyckTask<String,Void, ResultSet>{

    private Connection connection;
    private String query;

    public Execute (Connection connection, String query){
        this.connection = connection;
        this.query = query;
    }
//implementa a pesquisa no banco
    protected ResultSet doInBackground (String...params){
        ResultSet resultSet = null;
        try {
            resultSet = connection.prepareStatement(query).executeQuery();

        }catch (Exception e){

        }finally {
            try{
                connection.close();
            }catch (Exception ex){

            }
        }
    }

}
