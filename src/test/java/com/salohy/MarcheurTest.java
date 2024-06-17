package com.salohy;


import org.junit.jupiter.api.Test;
import org.salohy.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

class MarcheurTest {

    @Test
    void bjarni_marche_de_HEI_vers_ESTI() {
        // Create locations
        var marais = new Lieu("Marais");
        var sekolintsika = new Lieu("Sekolintsika");
        var hei = new Lieu("HEI");
        var pullman = new Lieu("Pullman");
        var balancoire = new Lieu("Balançoire");
        var boulevardDeLEurope = new Lieu("Boulevard de l'Europe");
        var nexta = new Lieu("Nexta");
        var esti = new Lieu("ESTI");

        // Create streets
        var rue1 = new Rue(marais, sekolintsika,null);
        var rue2 = new Rue(sekolintsika, hei, null);
        var rue3 = new Rue(hei, pullman ,"Rue Andriantsihoarana");
        var rue4 = new Rue(pullman, nexta, null);
        var rue5 = new Rue( pullman, balancoire, "Rue Ranaivo");
        var rue6 = new Rue(hei, balancoire, null);
        var rue7 = new Rue(balancoire, boulevardDeLEurope, null);
        var rue8 = new Rue(balancoire, esti, null);
        var rue9 = new Rue(boulevardDeLEurope, esti, null);

        // Create the map of Antananarivo
        var carteTana = new Carte(Set.of(rue1, rue2, rue3, rue4, rue5, rue6, rue7, rue8, rue9).toString());

        // Create the walker
        var bjarni = new Marcheur("Bjarni", carteTana);

        // Bjarni walks from HEI to ESTI
        Marche trajet = bjarni.marcher(hei, esti, carteTana);

        // Validate the start and end of the journey
        var lieuxVisites = trajet.lieuxVisites();
        var lieuDeDepart = lieuxVisites.get(0);
        var lieuDArrivee = lieuxVisites.get(lieuxVisites.size() - 1);
        var longueurTrajet = lieuxVisites.size();

        assertEquals(hei, lieuDeDepart, "La marche commence à HEI");
        assertEquals(esti, lieuDArrivee, "La marche se termine à ESTI");
        assertTrue(longueurTrajet >= 3, "Le trajet contient au moins 3 lieux, de HEI à ESTI");
    }
}

