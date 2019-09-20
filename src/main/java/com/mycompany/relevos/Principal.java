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
public class Principal{
    public static final String color_verde = "\u001B[32m";
    public static final String color_azul = "\u001B[34m";
    public static final String color_morado = "\u001B[35m";
/**
 * en esta clase inicializo los hilos con los valores y los inicio
 */
    public Principal(){
        Equipo equi1 = new Equipo("Equipo 1");
        Equipo equi2 = new Equipo("Equipo 2");
        Equipo equi3 = new Equipo("Equipo 3");
        
        Corredor corre1 = new Corredor(equi1,0,color_morado);
        Corredor corre2 = new Corredor(equi1,33,color_azul);
        Corredor corre3 = new Corredor(equi1,66,color_verde);
        Corredor corre4 = new Corredor(equi2,0,color_morado);
        Corredor corre5 = new Corredor(equi2,33,color_azul);
        Corredor corre6 = new Corredor(equi2,66,color_verde);
        Corredor corre7 = new Corredor(equi3,0,color_morado);
        Corredor corre8 = new Corredor(equi3,33,color_azul);
        Corredor corre9 = new Corredor(equi3,66,color_verde);
        
        corre1.start();
        corre2.start();
        corre3.start();
        corre4.start();
        corre5.start();
        corre6.start();
        corre7.start();
        corre8.start();
        corre9.start();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Principal principal = new Principal();
    }
}
