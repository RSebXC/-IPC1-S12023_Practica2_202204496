/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hilos;

import javax.swing.JLabel;

/**
 *
 * @author rodri
 */
public class Hilo2 extends Thread{
    JLabel circulo;
    int PosIniX;
    int PosFinX;
    int PosIniY;
    int PosFinY;
    int Velocidad;
    boolean ejecutar2;
    int dimension;
    
    public Hilo2(JLabel circulo, int PosIniX, int PosFinX, int PosIniY, int PosFinY) {
        this.circulo = circulo;
        this.PosIniX = PosIniX;
        this.PosFinX = PosFinX;
        this.PosIniY = PosIniY;
        this.PosFinY = PosFinY;
        this.Velocidad = 5;
        this.ejecutar2 = true;
        this.dimension = 43;
    }
    
    public void detener(){
    this.ejecutar2 = false;
    }
    
    @Override
    public void run(){
        while(ejecutar2){
               
        
        try{
        Thread.sleep(Velocidad);
        MoverCirculo2();
        }catch(InterruptedException ex){
        
        }
        }
}

private void MoverCirculo2(){
    
            if(PosIniX>PosFinX){
         this.circulo.setBounds(PosIniX, PosIniY, dimension, dimension);
         PosIniX-=2;
     }
            if(PosIniX<=PosFinX){
            if(PosIniY>PosFinY){
         this.circulo.setBounds(PosIniX, PosIniY, dimension, dimension);
                
         PosIniY-=2;
     }
            }
        if (PosIniX<=PosFinX && PosIniY<=PosFinY)this.ejecutar2 = false;
    }    
    
}
