package org.salohy;

public record Rue(Lieu lieu1, Lieu lieu2, String nom) {
    public Rue(Lieu lieu1, Lieu lieu2, String nom) {
        this.lieu1 = lieu1;
        this.lieu2 = lieu2;
        this.nom = nom;
    }
    public String getNom() {
        return nom;
    }
    public Lieu getLieu1() {
        return lieu1;
    }
    public Lieu getLieu2() {
        return lieu2;
    }
    @Override
    public Lieu lieu1() {
        return lieu1;
    }

    @Override
    public Lieu lieu2() {
        return lieu2;
    }

    @Override
    public String nom() {
        return nom;
    }

    public Lieu getLieuCorrespondant(Lieu lieu){
        if(lieu.equals(lieu1)){
            return lieu2;
        }else if(lieu.equals(lieu2)){
            return lieu1;
        }else{
            return null;
        }
    }
}
