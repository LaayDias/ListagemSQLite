package com.example.crud.produtossqlite;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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


        this.db.deleteProduto(nome.getText().toString());
        this.db.deleteProduto(preco.getText().toString());
        this.db.deleteProduto(desc.getText().toString());
        Toast.makeText(ApagarProduto.this, "APAGADO", Toast.LENGTH_SHORT).show();


    }
}
