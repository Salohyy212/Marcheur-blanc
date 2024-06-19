package org.salohy;


import java.util.HashSet;
import java.util.Set;

public class Carte {
    private final String nom;
    private final Set<Rue> rues;

    public Carte(String nom, Set<Rue> rues) {
        this.nom = nom;
        this.rues = rues;
    }

    public String getNom() {
        return nom;
    }

    public Set<Rue> getRues() {
        return rues;
    }

    public Carte(String nom) {
        this.nom = nom;
        this.rues = new HashSet<>();
    }


    public void ajouterRue(Rue rue) {
        rues.add(rue);
        rue.getLieu1().ajouterRue(rue);
        rue.getLieu2().ajouterRue(rue);
    }
}

