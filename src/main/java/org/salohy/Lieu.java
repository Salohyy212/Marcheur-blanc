package org.salohy;



import java.util.ArrayList;
import java.util.List;


public class Lieu {
    private final String nom;
    private final List<Rue> rues;

    public Lieu(String nom) {
        this.nom = nom;
        this.rues = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public List<Rue> getRues() {
        return rues;
    }

    public void ajouterRue(Rue rue) {
        this.rues.add(rue);
    }

    public List<Lieu> getLieuxAdjacents() {
        List<Lieu> lieuxAdjacents = new ArrayList<>();
        for (Rue rue : rues) {
            Lieu autreLieu = rue.getAutreLieu(this);
            if (autreLieu != null) {
                lieuxAdjacents.add(autreLieu);
            }
        }
        return lieuxAdjacents;
    }
}

