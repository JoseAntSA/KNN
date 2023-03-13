/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1_clasificador_knn;

/**
 *
 * @author anton
 */
import java.util.*;
import java.nio.file.*;
import java.io.*;

public class ManejoArchivos{

    private static Scanner lectura;

    //Abre Archivo
    public static void abrirArchivoLectura(){
        try{
            lectura = new Scanner(Paths.get("C:/Users/anton/Documents/Semestre 9/Sistemas Expertos/P1_Clasificador_KNN/build/classes/p1_clasificador_knn/reviews_sentiment.csv"));// Abre el archivo
        }
        catch(IOException ioException){
            System.err.println("  Error al abrir el archivo. Terminado.");
            System.err.println(ioException);
            System.exit(1); //Termina el programa
        }
    }

    //Leer registros al archivo
    public static ArrayList<Review> leerRegistros(){
        ArrayList<Review> datos = new ArrayList<>();
        Review resenia;
        try{
            String s = lectura.nextLine();
            while(lectura.hasNext()){
                resenia = new Review();

                s = lectura.nextLine();

                String[] sParts = s.split(";");
                resenia.setReviewTitle(sParts[0]);
                resenia.setReviewText(sParts[1]);
                resenia.setWordCount(Float.parseFloat(sParts[2]));
                resenia.setTitleSentiment(sParts[3]);
                resenia.setTextSentiment(sParts[4]);
                resenia.setStarRating(sParts[5]);
                resenia.setSentimentValue(Float.parseFloat(sParts[6]));

                datos.add(resenia);
            }
        }
        catch(NoSuchElementException elementException){
            System.err.println("El archivo no esta bien formado. Terminado");
        }
        catch(IllegalStateException stateException){
            System.err.println("Error al leer del archivo. Terminado");	
        }
        return(datos);
    }
	
    //Cierra el archivo
    public static void cerrarArchivoLectura(){
        if(lectura != null)
            lectura.close();
    }
}//Clase ManejoArchivos

