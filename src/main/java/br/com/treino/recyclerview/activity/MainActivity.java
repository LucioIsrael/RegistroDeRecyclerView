package br.com.treino.recyclerview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.treino.recyclerview.R;
import br.com.treino.recyclerview.RecyclerItemClickListener;
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

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Filme filme = listafilmes.get(position);
                                Toast.makeText(getApplicationContext(),
                                        "Item pressionado " + filme.getTituloFilme(),
                                        Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                Filme filme = listafilmes.get(position);
                                Toast.makeText(getApplicationContext(),
                                        "Clique longo " + filme.getGenero(),
                                        Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            }
                        }
                )
        );
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