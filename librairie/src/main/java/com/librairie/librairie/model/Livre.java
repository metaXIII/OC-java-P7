package com.librairie.librairie.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Livre {
    @Id
    @GeneratedValue
    private long id;

    private String nom;

    private String auteur;

    @Column(name = "DATEPARUTION")
    private Date dateParution;

    private String ISBN;

    @ManyToOne()
    @JoinColumn(name = "MAISONEDITION")
    private MaisonEdition maisonEdition;
}
