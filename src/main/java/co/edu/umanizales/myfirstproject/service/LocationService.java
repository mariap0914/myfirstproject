package co.edu.umanizales.myfirstproject.service;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LocationService {
    //lee el archivo
    private BufferedReader lector;
    //recibe la linea de cada fila
    private String linea;
    // almacena cada linea
    private String partes[]= null;

public void leerArchivo(String locations){

        try{
            lector = new BufferedReader(new FileReader(locations));
            while ((linea=lector.readLine())!=null){
                partes = linea.split(",");
                imprimirLinea();
                System.out.println();
            }
            lector.close();
            lector = null;
            partes=null;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
}

    public void imprimirLinea() {
    for(int i=0;i<partes.length;i++){
    System.out.println(partes[i]+"");}
    }

    }//fin clase




