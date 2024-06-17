package org.salohy;

import lombok.Getter;

@Getter
public record Rue(Lieu lieu1, Lieu lieu2, String nom) {
    public Rue(Lieu lieu1, Lieu lieu2, String nom) {
        this.lieu1 = lieu1;
        this.lieu2 = lieu2;
        this.nom = nom;
    }
    public Lieu getAutreLieu(Lieu lieu){
        if(lieu.equals(lieu1)){
            return lieu2;
        }else if(lieu.equals(lieu2)){
            return lieu1;
        }else{
            return null;
        }
    }
}
