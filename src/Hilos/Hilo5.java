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
public class Hilo5 extends Thread{
    JLabel circulo;
    int PosIniX;
    int PosFinX;
    int PosIniY;
    int PosFinY;
    int Velocidad;
    boolean ejecutar;
    int dimension;
    
    public Hilo5(JLabel circulo, int PosIniX, int PosFinX, int PosIniY, int PosFinY) {
        this.circulo = circulo;
        this.PosIniX = PosIniX;
        this.PosFinX = PosFinX;
        this.PosIniY = PosIniY;
        this.PosFinY = PosFinY;
        this.Velocidad = 35;
        this.ejecutar = true;
        this.dimension = 43;
    }
    
    public void detener(){
    this.ejecutar = false;
    }
    
    @Override
    public void run(){
        while(ejecutar){
               
        
        try{
        Thread.sleep(Velocidad);
        MoverCirculo5();
        }catch(InterruptedException ex){
        
        }
        }
}

private void MoverCirculo5(){
    
            if(PosIniY>PosFinY){
         this.circulo.setBounds(PosIniX, PosIniY, dimension, dimension);
         PosIniY-=2;
     }
            if(PosIniY<=PosFinY){
            if(PosIniX>PosFinX){
         this.circulo.setBounds(PosIniX, PosIniY, dimension, dimension);
                
         PosIniX-=2;
     }
            }
        if (PosIniX<=PosFinX && PosIniY<=PosFinY)this.ejecutar = false;
    }    
    
}
