package com.mehdik.geronimo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.mehdik.geronimo.Classes.Film;
import com.mehdik.geronimo.Utils.FilmAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView filmsRecycler;
    private List<Film> filmsList;

    public static String[] categoriesArray = {
            "Thriller",
            "Action",
            "Drame",
            "Comédie",
            "Horreur"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        filmsRecycler = (RecyclerView) findViewById(R.id.filmsRecyclerView);
        filmsList = new ArrayList<>();

        generateData(); //génération d'une liste de films

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        filmsRecycler.setLayoutManager(mLayoutManager);
        filmsRecycler.setHasFixedSize(true);

        //création de l'adapter + transmission des datas
        RecyclerView.Adapter mAdapter = new FilmAdapter(filmsList);
        filmsRecycler.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch(id) {

            case R.id.action_ajouter:
                addFilm();
                break;

            case R.id.action_retirer:
                removeFilm();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    //fonction qui génère des films pour la liste
    public void generateData() {

        final Film tmp1 = new Film();
        tmp1.setId(1);
        tmp1.setNom("Fight Club");
        tmp1.setCategorie(0);
        tmp1.setImg("http://images.affiches-et-posters.com//albums/3/577/affiche-fight-club-4514.jpg");

        final Film tmp2 = new Film();
        tmp2.setId(2);
        tmp2.setNom("Rambo");
        tmp2.setCategorie(1);
        tmp2.setImg("http://photos.lci.fr/images/820/490/rambo-820x490-e221fa-0@1x.jpeg");

        final Film tmp3 = new Film();
        tmp3.setId(3);
        tmp3.setNom("Intouchables");
        tmp3.setCategorie(2);
        tmp3.setImg("http://lesensdesimages.com/wp-content/uploads/2014/02/225914.jpg");

        filmsList.add(tmp1);
        filmsList.add(tmp2);
        filmsList.add(tmp3);
    }

    //ajoute un film à la liste
    public void addFilm() {

        final Film tmp = new Film();
        tmp.setId(1);
        tmp.setNom("Fight Club");
        tmp.setCategorie(1);
        tmp.setImg("http://images.affiches-et-posters.com//albums/3/577/affiche-fight-club-4514.jpg");

        if(filmsList.size()>0)
        {
            filmsList.add(1, tmp);
            filmsRecycler.getAdapter().notifyItemInserted(1);
        }
        else
        {
            filmsList.add(0, tmp);
            filmsRecycler.getAdapter().notifyItemInserted(0);
        }

    }

    //retire un film à la liste
    public void removeFilm() {

        //si la liste n'est pas vide, on retire le premier film
        if(filmsList.size()>0)
        {
            filmsList.remove(0);
            filmsRecycler.getAdapter().notifyItemRemoved(0);
        }
    }
}
