package br.com.treino.recyclerview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import br.com.treino.recyclerview.R;
import br.com.treino.recyclerview.adapter.Adapter;
import br.com.treino.recyclerview.model.Filme;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Filme> listafilmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        this.criarFilmes();

        Adapter adapter = new Adapter( listafilmes );

        //Primeira coisa
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration( this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);
    }

    public void criarFilmes(){

        Filme filme = new Filme("Homem Aranha sem volta pra casa", "Ação", "2021");
        this.listafilmes.add(filme);

        filme = new Filme("The batman", "ação", "2022");
        this.listafilmes.add(filme);

        filme = new Filme("Deadpool", "ação", "2019");
        this.listafilmes.add(filme);

        filme = new Filme("Rei leão", "aventura", "2018");
        this.listafilmes.add(filme);

        filme = new Filme("Homem formiga","ação", "2018" );
        this.listafilmes.add(filme);

        filme = new Filme("Mulher maravilha", "aventura", "2020");
        this.listafilmes.add(filme);

        filme = new Filme("Capitão América", "ação", "2010");
        this.listafilmes.add(filme);

        filme = new Filme("Divergente", "suspense", "2009");
        this.listafilmes.add(filme);

        filme = new Filme("A Bela e a fera", "romance", "2005");
        this.listafilmes.add(filme);

        filme = new Filme("Convergente", "comédia", "2009");
        this.listafilmes.add(filme);

    }

}