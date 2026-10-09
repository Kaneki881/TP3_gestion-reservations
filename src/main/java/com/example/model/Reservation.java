package com.example.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime debut;

    @Column(nullable = false)
    private LocalDateTime fin;

    @ManyToOne(optional = false)
    @JoinColumn(name = "utilisateur_id", nullable = false)
    private Utilisateur utilisateur;

    @ManyToOne(optional = false)
    @JoinColumn(name = "salle_id", nullable = false)
    private Salle salle;

    public Reservation() {
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDateTime getDebut() { return debut; }
    public void setDebut(LocalDateTime debut) { this.debut = debut; }

    public LocalDateTime getFin() { return fin; }
    public void setFin(LocalDateTime fin) { this.fin = fin; }

    public Utilisateur getUtilisateur() { return utilisateur; }
    public void setUtilisateur(Utilisateur utilisateur) { this.utilisateur = utilisateur; }

    public Salle getSalle() { return salle; }
    public void setSalle(Salle salle) { this.salle = salle; }
    @PrePersist
    @PreUpdate
    private void validerDates() {
        if (debut == null || fin == null || !debut.isBefore(fin)) {
            throw new IllegalArgumentException(
                    "La date de debut doit preceder la date de fin : ");
        }
    }
}