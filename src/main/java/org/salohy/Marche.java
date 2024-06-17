package org.salohy;

import lombok.Getter;


import java.util.List;

@Getter
public record Marche(List<Lieu> lieuxVisites) {


}
