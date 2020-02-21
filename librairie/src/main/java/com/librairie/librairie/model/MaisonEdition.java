package com.librairie.librairie.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "MAISONEDITION")
public class MaisonEdition {
    @Id
    @GeneratedValue
    private int id;

    private String nom;

    private String siret;
}
