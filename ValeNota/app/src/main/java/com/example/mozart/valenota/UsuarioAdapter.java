package com.example.mozart.valenota;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Mozart on 03/10/2016.
 */
public class UsuarioAdapter extends ArrayAdapter<Usuario> {

    private Context context;
    private ArrayList<Usuario> lista;

    public UsuarioAdapter (Context context, ArrayList<Usuario>lista){
        super (context,0,lista);
        this.context = context;
        this.lista = lista;
    }
    public View getView(int position, View convertView, ViewGroup parent){
        final Usuario itemPosicao = this.lista.get(position);

        convertView = LayoutInflater.from(this.context).inflate(R.layout.item_lista,null);
        final View layout = convertView;

        TextView textView = (TextView) convertView.findViewById(R.id.textViewNome);
        textView.setText(itemPosicao.getNome());

        TextView textViewEmail = (TextView) convertView.findViewById(R.id.textViewEmail);
        textViewEmail.setText(itemPosicao.getEmail());

        TextView textViewEndereço = (TextView) convertView.findViewById(R.id.textViewEndereço);
        textViewEndereço.setText(itemPosicao.getEndereço());

        TextView textViewCpf = (TextView) convertView.findViewById(R.id.textViewCPF);
        textViewCpf.setText(itemPosicao.getCpf());

        Button button = (Button) convertView.findViewById(R.id.buttonEditar);
        button.setOnClickListener ((V){

            Intent intent = new Intent(context,NovaActivity.class);

            intent.putExtra("nome", itemPosicao.getNome());
            intent.putExtra("email", itemPosicao.getEmail());
            intent.putExtra("endereço",itemPosicao.getEndereço());
            intent.putExtra("cpf", itemPosicao.getCpf());
            intent.putExtra("Id",itemPosicao.getId());
            context.startActivity(intent);

    });
        Button buttonDeletar = (Button) convertView.findViewById(R.id.buttonApagar);
        buttonDeletar.setOnClickListener ((V) {

                itemPosicao.apagar();
                if (itemPosicao._status)
                    layout.setVisibility(View.GONE);
                else
                    Toast.makeText(context,itemPosicao.get_menssagem(),Toast.LENGTH_SHORT).show();

        });
        return convertView;
    }


}
