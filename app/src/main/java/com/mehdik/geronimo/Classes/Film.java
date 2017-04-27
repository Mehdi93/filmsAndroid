package com.mehdik.geronimo.Classes;

/**
 * Created by Mehdi on 27/04/2017.
 */

public class Film {

    private int id;
    private String nom;
    private int categorie;
    private String imgUrl;

    public Film() {
        this.id = -1;
        this.nom = "";
        this.categorie = 0;
        this.imgUrl = "";
    }

    public Film(int id, String nom, int categorie, String imgUrl) {
        this.id = id;
        this.nom = nom;
        this.categorie = categorie;
        this.imgUrl = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getCategorie() {
        return categorie;
    }

    public void setCategorie(int categorie) {
        this.categorie = categorie;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImg(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
