package org.example;

import java.time.YearMonth;

public class Jugador {
    protected String jNombre, jApellidos, jDni, jEmail, jTelefono;
    protected int nacimiento, jDorsal, jGoles;

    public Jugador(String jNombre, String jApellidos, String jDni, String jEmail, String jTelefono, int nacimiento, int jDorsal, int jGoles) {
        this.jNombre = jNombre;
        this.jApellidos = jApellidos;
        this.jDni = jDni;
        this.jEmail = jEmail;
        this.jTelefono = jTelefono;
        this.nacimiento = nacimiento;


        if (jDorsal < 1 && jDorsal > 99) {
            this.jDorsal = 100;
        } else {
            this.jDorsal = jDorsal;

        }
        if(jGoles<0){
            this.jGoles=0;
        }else{
            this.jGoles = jGoles;
        }

    }

    public String getjNombre() {
        return jNombre;
    }

    public void setjNombre(String jNombre) {
        this.jNombre = jNombre;
    }

    public String getjApellidos() {
        return jApellidos;
    }

    public void setjApellidos(String jApellidos) {
        this.jApellidos = jApellidos;
    }

    public String getjDni() {
        return jDni;
    }

    public void setjDni(String jDni) {
        this.jDni = jDni;
    }

    public String getjEmail() {
        return jEmail;
    }

    public void setjEmail(String jEmail) {
        this.jEmail = jEmail;
    }

    public String getjTelefono() {
        return jTelefono;
    }

    public void setjTelefono(String jTelefono) {
        this.jTelefono = jTelefono;
    }

    public int getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(int nacimiento) {
        this.nacimiento = nacimiento;
    }

    public int getjDorsal() {
        return jDorsal;
    }

    public void setjDorsal(int jDorsal) {
        if(jDorsal<1&&jDorsal>99){
            this.jDorsal=100;
        }else{
            this.jDorsal = jDorsal;
        }

    }

    public int getjGoles() {
        return jGoles;
    }

    public void setjGoles(int jGoles) {
        if(jGoles<0){
            this.jGoles=0;
        }else{

        this.jGoles += jGoles;
    }
    }


    public Jugador(String sCadenaCSV){

        String[] atributos=sCadenaCSV.split(":")[0].split(";");
        if(atributos[0].equals("JUGADOR")){
            this.jNombre=atributos[0];
            this.jApellidos=atributos[1];
            this.jDni=atributos[2];
            this.jEmail=atributos[3];
            this.jTelefono=atributos[4];
            this.nacimiento=Integer.parseInt(atributos[5]);
            this.jDorsal=Integer.parseInt(atributos[6]);
            this.jGoles=Integer.parseInt(atributos[7]);

        }
    }

    public String toString(){
    StringBuilder sb;
    sb= new StringBuilder(String.format("JUGADOR:%s;%s;%s;%s;%s;%d;%d;%d\n",
                this.jNombre,this.jApellidos,this.jDni,this.jEmail,this.jTelefono,this.nacimiento,this.jDorsal,this.jGoles));

    return sb.toString();


    }

    public boolean mayorEdad(){
        int edad= YearMonth.now().getYear()-this.nacimiento;
        if(edad>17){
            return true;
        }else{
            return false;
        }

    }




}