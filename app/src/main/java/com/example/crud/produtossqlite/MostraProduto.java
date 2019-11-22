package com.example.crud.produtossqlite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MostraProduto extends AppCompatActivity {

    TextView nome, preco, desc;
    Button editar, deletar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostra_produto);

        if (getIntent() == null)
            finish();
        final String id = getIntent().getExtras().getString("ID");

        final DatabaseHandler db = new DatabaseHandler(this);

        final int MyID = Integer.parseInt(id);

        nome = (TextView) findViewById(R.id.nome);
        preco = (TextView) findViewById(R.id.preco);
        desc = (TextView) findViewById(R.id.desc);

        Produto p = db.getProduto(MyID);

        nome.setText(p.getNome());
        preco.setText(String.valueOf(p.getPreco()));
        desc.setText(p.getDesc());


        editar = (Button) findViewById(R.id.btnAlter);
        deletar = (Button) findViewById(R.id.btnDelete);


        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Intent intent = new Intent(MostraProduto.this, EditarProduto.class);
                intent.putExtra("ID", MyID);
                startActivity(intent);
            }
        });

        deletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.deleteProduto(String.valueOf(MyID));
                finish();
            }
        });


    }

}
