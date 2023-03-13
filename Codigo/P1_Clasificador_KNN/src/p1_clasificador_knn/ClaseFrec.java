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
public class ClaseFrec implements Comparable<ClaseFrec>{

    private String clase;
    private int frec;
    
    //Constructor
    public ClaseFrec(String clase, int frec){
        this.clase = clase;
        this.frec = frec;
    }

    public String getClase(){
      return clase;
    }//getClase
    public int getFrec(){
      return frec;
    }//getFrec

    //Metodo sobreescritos de la interfaz
    @Override
    public int compareTo( ClaseFrec obj ){

        if(this.getFrec() < obj.getFrec()){
            return 1;
        }
        else if(this.getFrec() > obj.getFrec()){
            return -1;
        }
        else{
            return 0;
        }
    }

}//Clase ClaseFrec
