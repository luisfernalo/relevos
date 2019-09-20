/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.relevos;

/**
 *
 * @author luis fernando
 */
public class Equipo { 
    private String nombreEquipo;
    private int posicion1 = 0;
    private int posicion2 = 33;
    private int posicion3= 66;
    
    public Equipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public int getPosicion1() {
        return posicion1;
    }

    public void setPosicion1(int posicion1) {
        this.posicion1 = posicion1;
    }

    public int getPosicion2() {
        return posicion2;
    }

    public void setPosicion2(int posicion2) {
        this.posicion2 = posicion2;
    }

    public int getPosicion3() {
        return posicion3;
    }

    public void setPosicion3(int posicion3) {
        this.posicion3 = posicion3;
    }
    /**
     * imprime la carrera co los colores del equipo
     * @return 
     */
    public synchronized String imprimir(){
        
        String puesto="";
        puesto = "Equipo: "+ nombreEquipo;
        for(int i = 0 ;i<=100;i++){
            if(nombreEquipo.equals("Equipo 1")){
                if (i == posicion1){
                    puesto += "\u001B[35m £";
                } else if(i == posicion2){
                    puesto += "\u001B[35m £";
                }else if(i == posicion3){
                    puesto += "\u001B[35m £";
                }else {
                    puesto += "_\u001B[35m";
                }
            }
            if(nombreEquipo.equals("Equipo 2")){
                if (i == posicion1){
                    puesto += "\u001B[34m £";
                } else if(i == posicion2){
                    puesto += "\u001B[34m £";
                }else if(i == posicion3){
                    puesto += "\u001B[34m £";
                }else {
                    puesto += "_\u001B[34m";
                }
            }
            if(nombreEquipo.equals("Equipo 3")){
                if (i == posicion1){
                    puesto += "\u001B[32m £";
                } else if(i == posicion2){
                    puesto += "\u001B[32m £";
                }else if(i == posicion3){
                    puesto += "\u001B[32m £";
                }else {
                    puesto += "_\u001B[32m";
                }
            }
        }
        //  System.out.println();    System.out.println();    System.out.println();
        return puesto;
    }
    
}
