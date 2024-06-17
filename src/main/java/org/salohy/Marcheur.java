package org.salohy;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Getter
public record Marcheur(String nom ) {
    public Marche marcher(Lieu lieuDepart, Lieu lieuArrivee, Carte carte){
        List<Lieu> trajet = new ArrayList<>();
        Random random = new Random();

        trajet.add(lieuDepart);
        Lieu positionActuelle = lieuDepart;
        while(!positionActuelle.equals(lieuArrivee)){
            List<Lieu> lieuxAdjacents = positionActuelle.getLieux();
            if(lieuxAdjacents.isEmpty()){
                break;
            }
            int indexAleatoire = random.nextInt((lieuxAdjacents.size()));
            positionActuelle = lieuxAdjacents.get(indexAleatoire);

            trajet.add(positionActuelle);
       }
        return new Marche(trajet);
    }

}
