package co.edu.umanizales.myfirstproject.service;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

public class LocationService {
    //lee el archivo
    private static BufferedReader lector;
    //recibe la linea de cada fila
    private static String linea;
    // almacena cada linea
    private static String[] partes = null;

    public static List<String[]> leerArchivo(String locations){


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
        return null;
    }

    public static void imprimirLinea() {
    for(int i=0;i<partes.length;i++){
    System.out.println(partes[i]+"");}
    }

    }//fin clase




