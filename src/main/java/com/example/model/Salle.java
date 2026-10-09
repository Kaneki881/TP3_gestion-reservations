package com.example.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Salle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nom;
    @Column(nullable = false)
    private Integer capacite;

    @OneToMany(mappedBy = "salle",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<Reservation> reservations = new HashSet<>();

    public Salle(String nom, Integer capacite) {
        this.nom = nom;
        this.capacite = capacite;
    }
    // Dans Salle
    @ManyToMany
    @JoinTable(
            name = "salle_equipement",
            joinColumns = @JoinColumn(name = "salle_id"),
            inverseJoinColumns = @JoinColumn(name = "equipement_id")
    )
    private Set<Equipement> equipements = new HashSet<>();

    public void addEquipement(Equipement equipement) {
        equipements.add(equipement);
        equipement.getSalles().add(this);
    }

    public void removeEquipement(Equipement equipement) {
        equipements.remove(equipement);
        equipement.getSalles().remove(this);
    }

    public Salle() {
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

    public Integer getCapacite() {
        return capacite;
    }

    public void setCapacite(Integer capacite) {
        this.capacite = capacite;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }
}
