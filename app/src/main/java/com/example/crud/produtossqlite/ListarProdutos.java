package com.example.crud.produtossqlite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class ListarProdutos extends AppCompatActivity {

    DatabaseHandler db;
    ListView list;

    List<Produto> listaProdutos;
    ProdutoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_produtos);

        db = new DatabaseHandler(this);
        list = (ListView) findViewById(R.id.listView);

        Toast.makeText(ListarProdutos.this, "Lendo todos os produtos..", Toast.LENGTH_LONG).show();
        listaProdutos = db.getAllProdutos();

        adapter = new ProdutoAdapter(this, listaProdutos);

        list.setAdapter(adapter);

        // ListView on item selected listener.
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                String produtoId = String.valueOf(listaProdutos.get(position).id);

                Intent intent = new Intent(ListarProdutos.this, MostraProduto.class);
                intent.putExtra("ID", produtoId);

                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        listaProdutos = db.getAllProdutos();
        adapter.clear();
        adapter.addAll(listaProdutos);
        adapter.notifyDataSetChanged();
    }
}
