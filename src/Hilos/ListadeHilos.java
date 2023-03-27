/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hilos;

import Interfaz.Simulacion;
import java.awt.LayoutManager;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 *
 * @author rodri
 */
public class ListadeHilos extends Thread{
    
    HiloT cronometro;
    int PosIniX;
    int PosFinX;
    int PosIniY;
    int PosFinY;
    int VelocidadGenerarA;
    int VelocidadGenerarV;
    int VelocidadGenerarM;
    int VelocidadGenerarR;
    int VelocidadGenerar;
   private  boolean ejecutarHilo;
    int dimension;
    int cantidad;
    int contador;
    int contador2;
    int contador3;
    int contador4;
    int contador5;
    JLabel min;
    JLabel seg;
    JLabel cont2;
    JLabel cont3;
    JLabel cont4;
    JLabel cont1;
    JFrame v;
    
    public ListadeHilos(JFrame v,int t1, int t2, int t3, int t4,JLabel min, JLabel seg,JLabel cont1,JLabel cont2,JLabel cont3,JLabel cont4) {
       // this.circulo = circulo;
        this.PosIniX = 1020;
        this.PosFinX = 950;
        this.PosIniY = 350;
        this.PosFinY = 550;
        this.VelocidadGenerarA =  t1 *1000;
        this.VelocidadGenerarV =  t2 *1000;
        this.VelocidadGenerarM =  t3 *1000;
        this.VelocidadGenerarR =  t4 *1000;
        this.VelocidadGenerar = 1000;
        this.ejecutarHilo = true;
        this.dimension = 43;
        this.cantidad = 30;
        this.contador = 1;
        this.contador2 = 1;
        this.contador3 = 1;
        this.contador4 = 1;
        this.contador5 = 1;
        this.v = v;
        this.min = min;
        this.seg = seg;
        this.cont1=cont1;
        this.cont2=cont2;
        this.cont3=cont3;
        this.cont4=cont4;
        
        this.cronometro = new HiloT(min,seg,1);
        cronometro.start();
    }
    
    
    
    @Override
    public void run(){
    
    
    
    while (ejecutarHilo){
        try{
            
    Thread.sleep(1000);
    if (contador <= cantidad){
     
            CrearCirculos();}
         
    Thread.sleep(VelocidadGenerarA);
    if (contador  >= 2 && contador2 <= cantidad){
    if (contador == 2)Thread.sleep(3000);
    CrearCirculosA();
    }
    
    Thread.sleep(VelocidadGenerarV);
    if (contador2 >= 2 && contador3 <= cantidad){
        if (contador2 == 2)Thread.sleep(4000);
    CrearCirculosV();
    }           
    
    Thread.sleep(VelocidadGenerarM);
    if (contador3 >= 2 && contador4 <= cantidad){
    if (contador3 == 2)Thread.sleep(3000);
    CrearCirculosM();
    }
    
    Thread.sleep(VelocidadGenerarR);
    if (contador4 >= 2 && contador5 <= cantidad){
    if (contador4 == 2)Thread.sleep(4000);
    CrearCirculosR();
    }
                     
        //if (PosFinX == 950 && PosFinY == 600)avanzar();
            }catch(InterruptedException ex){
                }
           }
    }
    
      
    
       private void CrearCirculos(){
        String color = "./src/Imagenes/Circulo.png";
        ImageIcon Img = new ImageIcon(color);
   JLabel circulo = new JLabel(Img);
          circulo.setVisible(true);
         v.getContentPane().add(circulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(782, 155, -1, -1));
    Hilo h = new Hilo(circulo,PosIniX,PosFinX,PosIniY,PosFinY,contador);
    h.start();
    contador ++;
    cont4.setText(String.valueOf(contador-1));
   // if (contador == 1)this.pricircu = circulo; 
    
    }
       
       private void CrearCirculosA(){
        String color = "./src/Imagenes/CirculoA.png";
        ImageIcon Img = new ImageIcon(color);
   JLabel circulo = new JLabel(Img);
          circulo.setVisible(true);
          
         v.getContentPane().add(circulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, -1, -1));
         //v.getContentPane().add(circulo, 0);
   Hilo2 h2 = new Hilo2(circulo,PosFinX,910,PosFinY,170);
    h2.start();
    contador2 ++;
     cont2.setText(String.valueOf(contador2-1));
    }
       
      private void CrearCirculosV(){
        String color = "./src/Imagenes/CirculoV.png";
        ImageIcon Img = new ImageIcon(color);
   JLabel circulo = new JLabel(Img);
          circulo.setVisible(true);
         v.getContentPane().add(circulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(782, 155, -1, -1));
   Hilo3 h3 = new Hilo3(circulo,970,480,170,180);
    h3.start();
    contador3 ++;
               cont1.setText(String.valueOf(contador3-1));
    } 
      
     private void CrearCirculosM(){
        String color = "./src/Imagenes/CirculoM.png";
        ImageIcon Img = new ImageIcon(color);
   JLabel circulo = new JLabel(Img);
          circulo.setVisible(true);
         v.getContentPane().add(circulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(782, 155, -1, -1));
   Hilo4 h4 = new Hilo4(circulo,480,410,180,550);
    h4.start();
    contador4 ++;
               cont3.setText(String.valueOf(contador4-1));
    }  
     
     
    private void CrearCirculosR(){
        String color = "./src/Imagenes/CirculoR.png";
        ImageIcon Img = new ImageIcon(color);
   JLabel circulo = new JLabel(Img);
          circulo.setVisible(true);
         v.getContentPane().add(circulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(782, 155, -1, -1));
   Hilo5 h5 = new Hilo5(circulo,430,280,550,380);
    h5.start();
    contador5 ++;
              if (contador == cantidad)cronometro.detener();
    }  
    
}
