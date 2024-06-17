package org.salohy;




import java.util.List;


public record Marche(List<Lieu> lieuxVisites) {
    public Marche(List<Lieu> lieuxVisites) {
        this.lieuxVisites = lieuxVisites;
    }
}
