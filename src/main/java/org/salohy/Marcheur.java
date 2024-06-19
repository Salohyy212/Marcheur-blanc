package org.salohy;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public record Marcheur(String nom) {
    @Override
    public String nom() {
        return nom;
    }

    public Marche marcher(Lieu lieuDepart, Lieu lieuArrivee) {
        ArrayList<Lieu> lieuxVisites = new ArrayList<>();

        Random random = new Random();

        lieuxVisites.add(lieuDepart);
        Lieu lieuActuel = lieuDepart;

        while (!lieuxVisites.contains(lieuArrivee)) {
            List<Rue> ruesActuelles = lieuActuel.getRues();

            if (ruesActuelles.isEmpty()) {
                throw new AucuneRue();
            }
            int indexAuHasard = random.nextInt( ruesActuelles.size());

            Rue rueAuHasard = ruesActuelles.get(indexAuHasard);

            lieuActuel = rueAuHasard.getLieuCorrespondant(lieuActuel);

            lieuxVisites.add(lieuActuel);
        }

        return new Marche(lieuxVisites);
    }
}
