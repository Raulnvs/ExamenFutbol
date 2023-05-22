package org.example;

public class Portero extends Jugador{
private int golesEncajados;
    public Portero(String jNombre, String jApellidos, String jDni, String jEmail, String jTelefono, int nacimiento, int jDorsal, int jGoles, int golesEncajados) {
        super(jNombre, jApellidos, jDni, jEmail, jTelefono, nacimiento, jDorsal, jGoles);
        if(golesEncajados<0){
            this.golesEncajados=0;
        }else{
            this.golesEncajados=golesEncajados;
        }
    }

    public Portero(String sCadenaCSV) {
        super(sCadenaCSV);
        String[] atributos=sCadenaCSV.split(":")[1].split(";");
        this.golesEncajados=Integer.parseInt(atributos[8]);
    }

    public int getGolesEncajados() {
        return golesEncajados;
    }

    public void setGolesEncajados(int golesEncajados) {
        if(golesEncajados<0){
            this.golesEncajados=0;
        }else{
            this.golesEncajados+=golesEncajados;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb;
        sb= new StringBuilder(String.format("PORTERO:%s;%s;%s;%s;%s;%d;%d;%d;%d\n",
                super.jNombre,super.jApellidos,super.jDni,super.jEmail,super.jTelefono,super.nacimiento,super.jDorsal,super.jGoles,this.golesEncajados));

        return sb.toString();
    }
}
