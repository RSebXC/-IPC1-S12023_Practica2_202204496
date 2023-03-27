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
public class Hilo extends Thread{
    JLabel circulo;
    int PosIniX;
    int PosFinX;
    int PosIniY;
    int PosFinY;
    int Velocidad;
    boolean ejecutar;
    int dimension;
    int contador;

    public Hilo(JLabel circulo, int PosIniX, int PosFinX, int PosIniY, int PosFinY,int contador) {
        this.circulo = circulo;
        this.PosIniX = PosIniX;
        this.PosFinX = PosFinX;
        this.PosIniY = PosIniY;
        this.PosFinY = PosFinY;
        this.Velocidad = 5;
        this.ejecutar = true;
        this.dimension = 43;
        this.contador = contador;
    }
    public void detener(){
    this.ejecutar = false;
    }
    
    @Override
    public void run(){
        while(ejecutar){
               
        
        try{
        Thread.sleep(Velocidad);
        MoverCirculo1();
        }catch(InterruptedException ex){
        
        }
        }
}
    
    private void MoverCirculo1(){
    
            if(PosIniX>PosFinX){
         this.circulo.setBounds(PosIniX, PosIniY, dimension, dimension);
         PosIniX-=2;
     }
            if(PosIniX<=PosFinX){
            if(PosIniY<PosFinY){
         this.circulo.setBounds(PosIniX, PosIniY, dimension, dimension);
                
         PosIniY+=2;
     }
            }
        if (PosIniX<=PosFinX && PosIniY>=PosFinY)this.ejecutar = false;
            //if (contador > 1)this.circulo.setVisible(false);
        
    }
    
    
    
}
