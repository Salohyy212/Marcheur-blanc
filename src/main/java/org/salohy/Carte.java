package org.salohy;

import lombok.Getter;

import java.util.Set;

@Getter
public record Carte(String nom, Set<Lieu> lieux) {
}
