package org.example;

import java.util.Comparator;

public class CompararGoles implements Comparator<Jugador> {
    @Override
    public int compare(Jugador j1, Jugador j2){
        return j2.getjGoles()-j1.getjGoles();
    }
}
