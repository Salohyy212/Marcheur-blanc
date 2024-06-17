package org.salohy;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public record Marcheur(String nom, Carte carte) {
    @Override
    public String nom() {
        return nom;
    }

    @Override
    public Carte carte() {
        return carte;
    }

    public Marche marcher(Lieu lieuDepart, Lieu lieuArrivee, Carte carte) {
        List<Lieu> trajet = new ArrayList<>();
        Random random = new Random();

        trajet.add(lieuDepart);
        Lieu positionActuelle = lieuDepart;

        while (!positionActuelle.equals(lieuArrivee)) {
            List<Lieu> lieuxAdjacents = positionActuelle.getLieuxAdjacents();
            if (lieuxAdjacents.isEmpty()) {
                break;
            }
            int indexLieuAdjacent = random.nextInt(lieuxAdjacents.size());
            positionActuelle = lieuxAdjacents.get(indexLieuAdjacent);

            trajet.add(positionActuelle);
        }

        return new Marche(trajet);
    }
}
