package com.example.crud.produtossqlite;

import android.drm.DrmStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MostraProduto extends AppCompatActivity {

    TextView nome,preco,desc;
    Button editar, deletar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostra_produto);

        String id=getIntent().getExtras().getString("ID");

        DatabaseHandler db = new DatabaseHandler(this);


        int MyID = Integer.parseInt(id);

        nome= (TextView) findViewById(R.id.nome);
        preco= (TextView) findViewById(R.id.preco);
        desc= (TextView) findViewById(R.id.desc);

        Produto p = db.getProduto(MyID);

        nome.setText(p.getNome());
        preco.setText(""+p.getPreco());
        desc.setText(p.getDesc());


        editar = (Button) findViewById(R.id.btnAlter);
        deletar = (Button) findViewById(R.id.btnDelete);


    }

}
