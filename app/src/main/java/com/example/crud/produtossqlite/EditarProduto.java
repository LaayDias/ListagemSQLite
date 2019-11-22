package com.example.crud.produtossqlite;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditarProduto extends AppCompatActivity {
    EditText nome, preco, desc;
    Button editar;
    DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edita_produto);

        int produtoId = getIntent().getIntExtra("ID", 0);
        db = new DatabaseHandler(this);
        Produto produto = db.getProduto(produtoId);

        nome = (EditText) findViewById(R.id.nome);
        preco = (EditText) findViewById(R.id.preco);
        desc = (EditText) findViewById(R.id.desc);
        editar = (Button) findViewById(R.id.btnDelete);
        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //configurar aqui o btn editar
                //voltar para "mostrar produto

                String n = nome.getText().toString();
                double pr = Double.parseDouble(preco.getText().toString());

                String d = desc.getText().toString();

                Produto p = new Produto(n, pr, d);

                long id = db.updateProduto(p);
                finish();


            }
        });
        nome.setText(produto.nome);
        preco.setText(String.valueOf(produto.preco));
        desc.setText(produto.desc);

    }
}
