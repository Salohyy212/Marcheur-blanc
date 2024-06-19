package org.salohy;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public record Marcheur(String nom) {
    @Override
    public String nom() {
        return nom;
    }

    public Marche marcher(Lieu lieuDepart, Lieu lieuArrivee) throws AucuneRue {
        ArrayList<Lieu> trajet = new ArrayList<>();
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
