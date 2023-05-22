package org.example;

import java.util.Comparator;

public class ComparadorJugador implements Comparator<Jugador> {
    @Override
    public int compare(Jugador j1, Jugador j2){
        String fullName1=j1.getjApellidos()+" "+j1.getjNombre();
        String fullName2=j2.getjApellidos()+" "+j2.getjNombre();
        return fullName1.compareTo(fullName2);
    }
}
