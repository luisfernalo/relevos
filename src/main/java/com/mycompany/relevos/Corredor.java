/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.relevos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luis fernando
 */
public class Corredor extends Thread{
    Equipo equipo;
    public int posicion;
    public String color;
    public int pasos;
    public String equipo1;
    public String equipo2;
    public String equipo3;

    public Corredor(Equipo equipo, int posicion, String color) {
        this.equipo = equipo;
        this.posicion = posicion;
        this.color = color;
        
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPasos() {
        return pasos;
    }

    public void setPasos(int pasos) {
        this.pasos = pasos;
    }
    
  /**
   * 
   * @param minimo
   * @param maximo
   * @return 
   * genera los numeros random para los pasos
   */
    public static int pasosrandom(int minimo, int maximo){
        int num = (int) Math.floor(Math.random() * (maximo - minimo +1)+(1));
        return num;
    }
/**
 * movimiento de los jugadores
 */
    @Override
    public void run() {
        if( posicion == 0){
            mover1();
        }else {
            detener();
        }
        if( posicion == 33){
            mover2();
        }else {
            detener();
        }
        if( posicion == 66){
            mover3();
        }else {
            detener();
        }
    }  
/**
 * el corredor que va de 0 a 33
 */
    private void mover1() {
        do{
          int mueve=pasosrandom(1,3);
          equipo.setPosicion1(equipo.getPosicion1()+mueve);
          mostrar();
          if(equipo.getPosicion1()>=33){
              equipo.setPosicion1(33);
              synchronized (equipo){
                  equipo.notifyAll();
                  posicion=33;
              }
              break;
          }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE, null, ex);
        }  
        }while(true);
    }
/**
 * el corredor que va de 33 a 66
 */
    private void mover2() {
        do{
          int mueve=pasosrandom(1,3);
          equipo.setPosicion2(equipo.getPosicion2()+mueve);
          mostrar();
          if(equipo.getPosicion2()>=66){
              equipo.setPosicion2(66);
              synchronized (equipo){
                  equipo.notify();
              }
              break;
          }
          try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE, null, ex);
        }
        }while(true);
    }
    /**
     * el corredor que llega a el final
     */
    private void mover3() {
        do{
          int mueve=pasosrandom(1,3);
          equipo.setPosicion3(equipo.getPosicion3()+mueve);
          mostrar();
          if(equipo.getPosicion3()>=100){
              equipo.setPosicion3(100);
              System.out.println("carril ganador: "+ equipo.getNombreEquipo());
              System.exit(0);
          }
          try {
            Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }while(true);
    }
    /**
     * imprimir la consola con la carrera segun el equipo
     */
    public void mostrar(){
        if(equipo.imprimir().contains("Equipo 1")){
            equipo1 = equipo.imprimir();
            if(equipo1 != null){
                System.out.println(equipo1);
            }
        }else if(equipo.imprimir().contains("Equipo 2")){
            equipo2 = equipo.imprimir();
            if(equipo2 != null){
                System.out.println(equipo2);
            }
        }else if(equipo.imprimir().contains("Equipo 3")){
            equipo3 = equipo.imprimir();
            if(equipo3 != null){
                System.out.println(equipo3);
            }
        }
    }
/**
 * detiene a los otros hilos
 */
    private void detener() {
        synchronized (equipo){
            try{
                equipo.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Corredor.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
