package com.mehdik.geronimo.Utils;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mehdik.geronimo.Classes.Film;
import com.mehdik.geronimo.R;

import java.util.List;

/**
 * Created by Mehdi on 27/04/2017.
 */

public class FilmAdapter extends RecyclerView.Adapter<FilmViewHolder> {

    private List<Film> list;

    //ajouter un constructeur prenant en entrée une liste
    public FilmAdapter(List<Film> list) {
        this.list = list;
    }


    @Override
    public FilmViewHolder onCreateViewHolder(ViewGroup viewGroup, int itemType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_film, viewGroup,false);
        return new FilmViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FilmViewHolder myViewHolder, int position) {
        Film myObject = list.get(position);
        myViewHolder.bind(myObject);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}