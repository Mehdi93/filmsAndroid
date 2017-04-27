package com.mehdik.geronimo.Utils;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mehdik.geronimo.Classes.Film;
import com.mehdik.geronimo.MainActivity;
import com.mehdik.geronimo.R;
import com.squareup.picasso.Picasso;

/**
 * Created by Mehdi on 27/04/2017.
 */

class FilmViewHolder extends RecyclerView.ViewHolder {

    private ImageView illustrationImage;
    private TextView titreText;
    private TextView categorieText;
    private Button detailButton;
    private Button partageButton;

    //itemView est la vue correspondante à 1 cellule
    FilmViewHolder(View itemView) {
        super(itemView);

        illustrationImage = (ImageView) itemView.findViewById(R.id.illustrationViewCard);
        titreText = (TextView) itemView.findViewById(R.id.titreTextCard);
        categorieText = (TextView) itemView.findViewById(R.id.categorieTextCard);
        detailButton = (Button) itemView.findViewById(R.id.detailButtonCard);
        partageButton = (Button) itemView.findViewById(R.id.partageButtonCard);

    }

    void bind(final Film film){

        //on affiche dans la card les différentes informations du film
        titreText.setText(film.getNom());
        categorieText.setText(MainActivity.categoriesArray[film.getCategorie()]);
        Picasso.with(itemView.getContext()).load(film.getImgUrl()).into(illustrationImage);

        detailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(itemView.getContext(), film.getNom()+", excellent choix !", Toast.LENGTH_SHORT).show();
            }
        });

        //bouton de partage
        partageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "J'adore "+film.getNom()+ " c'est le meilleur film de tout les temps !");
                sendIntent.setType("text/plain");
                itemView.getContext().startActivity(sendIntent);
            }
        });

    }


}