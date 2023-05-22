package org.example;

import java.io.*;
import java.util.Scanner;

public class ControladorFicheros {

    public static boolean grabarEquipoCSV(String sNombreFichero, Equipo e) {

        FileWriter fileWriter = null;
        PrintWriter printWriter;
        boolean correcto;

        try {
            fileWriter = new FileWriter(sNombreFichero);
            printWriter = new PrintWriter(fileWriter);
            printWriter.print(e.toString());
            printWriter.flush();
            fileWriter.close();
            fileWriter = null;
            correcto = true;
        } catch (IOException ex) {
            correcto = false;
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException ex) {
                    correcto = false;
                }
            }
        }
        return correcto;
    }

    public static Equipo leerEquipoCSV(String sNombreFichero) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(sNombreFichero), "UTF-8"))) {
            String linea;
            StringBuilder sb = new StringBuilder();
            while ((linea = reader.readLine()) != null) {
                sb.append(linea).append("\n");
            }
            String equipoCSV = sb.toString().trim();
            return new Equipo(equipoCSV);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

    }
}