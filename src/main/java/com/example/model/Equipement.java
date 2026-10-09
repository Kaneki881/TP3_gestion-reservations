package com.example.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Equipement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nom;

    @ManyToMany(mappedBy = "equipements")
    private Set<Salle> salles = new HashSet<>();

    public Equipement(Long id, String nom, Set<Salle> salles) {
        this.id = id;
        this.nom = nom;
        this.salles = salles;
    }

    @ManyToMany(mappedBy = "equipements")

    public Set<Salle> getSalles() {
        return salles;
    }

    public Equipement() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    public void setSalles(Set<Salle> salles) {
        this.salles = salles;
    }
}