package com.example.crud.produtossqlite;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class ProdutoAdapter extends ArrayAdapter<Produto> {


    ProdutoAdapter(Context context, List<Produto> lista) {
        super(context, 0, lista);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        Produto produto = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.linha_item_produto, parent, false);
        }

        if (produto == null)
            return convertView;

        TextView mNome = (TextView) convertView.findViewById(R.id.t_nome);
        TextView mId = (TextView) convertView.findViewById(R.id.t_id);
        TextView mPreco = (TextView) convertView.findViewById(R.id.t_preco);


        mNome.setText(produto.nome);

        mId.setText(String.valueOf(produto.id));

        mPreco.setText(String.valueOf(produto.preco));

        return convertView;
    }

}
