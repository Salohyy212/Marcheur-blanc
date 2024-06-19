package com.salohy;


import org.junit.jupiter.api.Test;
import org.salohy.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

class MarcheurTest {

    @Test
    void bjarni_marche_aleatoire_de_HEI_vers_ESTI() {
        var marais = new Lieu("Marais");
        var sekolintsika = new Lieu("Sekolintsika");
        var hei = new Lieu("HEI");
        var pullman = new Lieu("Pullman");
        var balancoire = new Lieu("Balançoire");
        var boulevardDeLEurope = new Lieu("Boulevard de l'Europe");
        var nexta = new Lieu("Nexta");
        var esti = new Lieu("ESTI");

        var rue1 = new Rue(marais, sekolintsika,"");
        var rue2 = new Rue(sekolintsika, hei, "");
        var rue3 = new Rue(hei, pullman ,"Rue Andriantsihoarana");
        var rue4 = new Rue(pullman, nexta, "");
        var rue5 = new Rue( pullman, balancoire, "Rue Ranaivo");
        var rue6 = new Rue(hei, balancoire, "");
        var rue7 = new Rue(balancoire, boulevardDeLEurope, "");
        var rue8 = new Rue(balancoire, esti, "");
        var rue9 = new Rue(boulevardDeLEurope, esti, "");

        marais.ajouterRue(rue1);

        sekolintsika.ajouterRue(rue1);
        sekolintsika.ajouterRue((rue2));

        hei.ajouterRue(rue2);
        hei.ajouterRue(rue3);
        hei.ajouterRue(rue6);

        pullman.ajouterRue(rue3);
        pullman.ajouterRue(rue4);
        pullman.ajouterRue(rue5);

        balancoire.ajouterRue(rue6);
        balancoire.ajouterRue(rue7);
        balancoire.ajouterRue(rue8);

        boulevardDeLEurope.ajouterRue(rue7);
        boulevardDeLEurope.ajouterRue(rue9);

        esti.ajouterRue(rue8);
        esti.ajouterRue(rue9);

        var carteTana = new Carte(Set.of(rue1, rue2, rue3, rue4, rue5, rue6, rue7, rue8, rue9).toString());

        var bjarni = new Marcheur("Bjarni");

        Marche trajet = bjarni.marcher(hei, esti);

        var lieuxVisites = trajet.lieuxVisites();

        var longueurTrajet = lieuxVisites.size();

        assertEquals(hei, lieuxVisites.getFirst(), "La marche commence à HEI");
        assertEquals(esti, lieuxVisites.getLast(), "La marche se termine à ESTI");

        for (int i = 0; i < lieuxVisites.size(); i++) {
            System.out.println(lieuxVisites.get(i).getNom());
        }

        int deplacementMinimale = 3;

        assertTrue(longueurTrajet >= deplacementMinimale, "Le trajet contient au moins 3 lieux, de HEI à ESTI");

        for(int i = 0; i < lieuxVisites.size() - 1; i++){
            Lieu lieuActuel = lieuxVisites.get(i);
            Lieu lieuSuivant = lieuxVisites.get(i + 1);
            assertTrue(lieuActuel.getLieuxAdjacents().contains(lieuSuivant), "Chaque lieu visité doit-être adjacent au lieu précédent");
        }
    }
}

