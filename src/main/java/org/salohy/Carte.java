package org.salohy;

import lombok.Getter;
import java.util.HashSet;
import java.util.Set;

@Getter
public class Carte {
    private final String nom;
    private final Set<Lieu> lieux;
    private final Set<Rue> rues;

    public Carte(String nom) {
        this.nom = nom;
        this.lieux = new HashSet<>();
        this.rues = new HashSet<>();
    }

    public void ajouterLieu(Lieu lieu) {
        lieux.add(lieu);
    }

    public void ajouterRue(Rue rue) {
        rues.add(rue);
        rue.getLieu1().ajouterRue(rue);
        rue.getLieu2().ajouterRue(rue);
    }
}

