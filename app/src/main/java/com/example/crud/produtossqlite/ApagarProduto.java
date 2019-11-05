package com.example.crud.produtossqlite;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ApagarProduto extends AppCompatActivity {

    EditText nome,preco, desc;
    Button delete;
    DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostra_produto);

        db = new DatabaseHandler(this);

        nome = (EditText) findViewById(R.id.nome);

        preco = (EditText) findViewById(R.id.preco);

        desc = (EditText) findViewById(R.id.desc);

        delete = (Button) findViewById(R.id.btnDelete);

        delete.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                //configurar aqui o btn delete
                //voltar para lista de produtos com o produto já excluido

            }
        });

    }
}
