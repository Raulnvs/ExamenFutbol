package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.MatchResult;

public class Equipo {
    private String eNombre;
    private int puntuacion;
    private String ciudad;
    private String email;
    HashMap<String,Jugador>jugadores;
    Portero[] porteros;

    public Equipo(String eNombre, int puntuacion, String ciudad, String email) {
        this.eNombre = eNombre;
        if(puntuacion<0){
            this.puntuacion=0;
        }else{
            this.puntuacion = puntuacion;
        }
        this.ciudad = ciudad;
        this.email = email;
        this.jugadores=new HashMap<>();
        this.porteros=new Portero[2];
    }
    public Equipo(String sCadenaCSV){
        String[] datos = sCadenaCSV.split("\n");
        String[] equipoDatos = datos[0].split(": ")[1].split(";");
        this.eNombre = equipoDatos[0];
        this.puntuacion = Integer.parseInt(equipoDatos[1]);
        this.ciudad = equipoDatos[2];
        this.email = equipoDatos[3];
        this.porteros = new Portero[2];
        this.jugadores = new HashMap<>();

        for (int i = 1; i < datos.length; i++) {
            String tipo = datos[i].split(":")[0];
            String jugadorDatos = datos[i].split(":")[1];
            if (tipo.equals("PORTERO")) {
                Portero portero = new Portero(jugadorDatos);
                addPortero(portero);
            } else if (tipo.equals("JUGADOR")) {
                Jugador jugador = new Jugador(jugadorDatos);
                addJugador(jugador);
            }
        }



    }
    public String geteNombre() {
        return eNombre;
    }

    public void seteNombre(String eNombre) {
        this.eNombre = eNombre;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        if(puntuacion<0){
            this.puntuacion=0;
        }else{
            this.puntuacion = puntuacion;
        }
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    //MÉTODOS DE LA CLASE EQUIPO
public boolean addPortero(Portero p){
        for(int i=0;i<porteros.length;i++){
            if(porteros[i]==null){

                    porteros[i]=p;
                    return true;

            }
        }
        return false;
}
public boolean addJugador(Jugador j){
        if(jugadores.containsKey(j.getjDni())){
            return false;
        }else{
            jugadores.put(j.jDni,j);
            return true;
        }

}

public boolean eliminarPortero(String dni){
        for(int i=0;i<porteros.length;i++){
            if(porteros[i].equals(dni)){
                porteros[i]=null;
                return true;
            }
        }
        return false;
}
public boolean eliminarJugador(String dni){
        if(jugadores.containsKey(dni)){
            jugadores.remove(dni);
            return true;
        }
        return false;

}


public boolean isActivo(){
      if(porteros[0]!=null||porteros[1]!=null&&jugadores.size()>5) {
          return true;
      }
          return false;
}
public ArrayList<Jugador> menoresEdad(){
        ArrayList<Jugador> jugadoresMenores=new ArrayList<>();


        //primero comprobamos los jugadores
    for(Jugador jugador:this.jugadores.values()){
        if(!jugador.mayorEdad()){
            jugadoresMenores.add(jugador);
        }
    }
    //segundo lugar los porteros
    for(Portero portero: porteros){
        if(!portero.mayorEdad()){
            jugadoresMenores.add(portero);
        }
    }

    jugadoresMenores.sort(new ComparadorJugador());

return jugadoresMenores;
}
public ArrayList<Jugador> jugadoresTitulares(){
    ArrayList<Jugador> titulares=new ArrayList<>();
    //Obtener el portero con menos goles encajados
    Portero porteroTitular = null;//inicializamos un nuevo portero como  porteroTitular en null
    int numeroGoles=-1;//-1 para asegurarsse que hay portero con golEncajado
    for(Portero portero:porteros) {
        if(portero!=null) {//si el nuevo portero contiene datos
            int golesEncajados=portero.getGolesEncajados();//añadimos en una variable golesEncajados los goles del portero
            if(porteroTitular==null||golesEncajados<numeroGoles) {
                porteroTitular=portero;
                numeroGoles=golesEncajados;
                /*
                 * Si no se ha asigando ningún portero y el numero de goles encajados por el portero
                 * es menor que el numero de goles, el portero actual tendrá menos goles encajados que el porteroTitular
                 * actual
                 */
            }
        }
    }
    if(porteroTitular!=null) {//si el nuevo portero no esta null se añadira a la lista de titulares
        titulares.add(porteroTitular);
    }

    //Obtener los jugadores con más goles sin contar el portero
    ArrayList<Jugador> jugadoresSinPortero=new ArrayList<>();
    for(Jugador jugador:jugadores.values()) {
        if(!(jugador instanceof Portero)) {//si el jugador no es un portero
            jugadoresSinPortero.add(jugador);//jugador se añadira a la lista de jugadoressinportero
        }
    }
    jugadoresSinPortero.sort(new CompararGoles());

    //obeter el numero maximo de jugadores titulares max 5
    int numJugadores=jugadoresSinPortero.size();//si la lista tiene mas de 5 jugadores se le asigna en 5 directamente
    if(numJugadores>5) {
        numJugadores=5;
    }
    //agregar los jugadores titulares a la lista de titulares
    for(int i=0;i<numJugadores;i++) {
        titulares.add(jugadoresSinPortero.get(i));
    }
    return titulares;


}

@Override
    public String toString(){
      StringBuilder sb=new StringBuilder();
      sb.append("EQUIPO:").append(eNombre).append(";").append(ciudad).append(";").append(email).append("\n");
      for(Portero portero:porteros){
          if(portero!=null){
              sb.append(portero);
          }
      }
      for(Jugador jugador:jugadores.values()){
          sb.append(jugador);
      }
      return sb.toString();
}
}
