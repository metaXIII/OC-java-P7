package com.librairie.reservation.beans;

import lombok.Data;

import java.util.Date;

@Data
public class LivreBean {
    private long id;

    private String nom;

    private String auteur;

    private Date dateParution;

    private String ISBN;

    private String categorie;

    private String resume;

    private int quantite;
}
