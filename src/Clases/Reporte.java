/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
/**
 *
 * @author rodri
 */
public class Reporte {
    String reporte;
    String nombre;
    
    public Reporte(){
    
    this.reporte = "";
    this.nombre = "";
}
    
    public boolean CrearDoc(String nombre,String carne,  String nomcom, String t1, String t2, String t3, String t4, String p1, String p2 , String p3, String p4, String tot1, String tot2, String tot3, String tot4,String tf){
        this.nombre = nombre;
        try {
            
            /* Se crea el archivo con el nombre que se le envia*/
            FileOutputStream archivo = new FileOutputStream(nombre+".html"); 
            /* Esta instancia de OutputStreamWriter nos permitira escribir en el archivo */
            OutputStreamWriter  osw = new OutputStreamWriter (archivo, StandardCharsets.UTF_8);
            /* Metodo para crear el reporte */
            crearReporte(nombre,carne, nomcom, t1,t2,t3,t4,p1,p2,p3,p4,tot1,tot2,tot3,tot4,tf);
            /* Se escribe la cadena para formar el contenido del archivo */
            osw.write(this.reporte);
            /* Se cierra el documento esto siempre se debe hacer para que no se presente
            ningun problema*/
            osw.close();
            archivo.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error "+e);
            return false;
        }
    }
        
        public void crearReporte(String titulo,String carne,String nombre,  String t1, String t2, String t3, String t4, String p1, String p2 , String p3, String p4, String tot1, String tot2, String tot3, String tot4, String tf){
        /* Estructura basica de un archivo HTML */
        this.reporte += "<!DOCTYPE html>\n";
        this.reporte += "<html>\n";
        this.reporte += "<head>\n";
        this.reporte += "\t<meta charset=\"utf-8\">\n";
        this.reporte += "\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n";
        /* Titulo a mostrar en la pestaña del navegador */
        this.reporte += "\t<title>"+titulo+"</title>\n";
        this.reporte += "</head>\n";
        this.reporte += "<body>\n";
        /* Titulo a mostrar en la pagina */
        this.reporte += "<h1>"+titulo+"</h1>\n";
        /* Salto de linea */
        nextLine();
        /* Datos del usuario */
        datosUsuario(carne,nombre);
        /* Salto de linea */
        nextLine();
        /* Creacion de la tabla de productos*/
        datosSimu(t1,t2,t3,t4,p1,p2,p3,p4,tot1,tot2,tot3,tot4,tf);
        /* Cierre del cuerpo y del archivo HTML */
        this.reporte += "</body>\n";
        this.reporte += "</html>";
    }
    
    
    private void datosUsuario(String carne,String nombre){
        /*  Se crea la etiqueta que abre una lista para mostrar los datos del usuario */
        this.reporte += "\t<ul>\n";
        /* Se agregan los elemento a la lista */
        nextData("Carne: "+ carne);
        nextData("Nombre: "+ nombre);
        nextData("Fecha: " + String.valueOf(LocalDateTime.now()));
        /*  Se crea la etiqueta que cierra la lista */
        this.reporte += "\t<ul>\n";
    }
    
    private void datosSimu( String t1, String t2, String t3, String t4, String p1, String p2 , String p3, String p4, String tot1, String tot2, String tot3, String tot4,String tf){
    this.reporte += "\t<ul>\n";
    nextLine();
    nextLine();
    nextData("Area: Inventario" + " Tiempo: " + t1+ " Costo: " + p1 + " Total: " + tot1);
    nextData("Area: Produccion" + " Tiempo: " + t2+ " Costo: " + p2 + " Total: " + tot2);
    nextData("Area: Empaquetado" + " Tiempo: " + t3+ " Costo: " + p3 + " Total: " + tot3);
    nextData("Area: Salida" + " Tiempo: " + t4+ " Costo: " + p4 + " Total: " + tot4);
    nextLine();
    nextLine();
    nextData("El total de todo el proceso es de: "+tf);
    }
    
    
    private void nextData(String dato){
        /* Se crea la etiqueta para mostrar el elemento */
        this.reporte += "\t\t<li>"+dato+"</li>\n";
    }
    
    
    private void nextLine(){
        /* Se crea la etiqueta para un salto de linea */
        this.reporte += "\t<br>\n";
    }
    
    public boolean AbrirArchivo(){
        try {
            /* Se obtiene el archivo a traves de File
              * al realizar la instancia se debe colocar la ruta del archivo
              * en este caso solo se coloca el nombre y la extension debido a que
              * se encuentra en la misma carpeta del proyecto */
            File path = new File(nombre+".html");
            /* Se abrira el archivo */
            Desktop.getDesktop().open(path);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
        
        
    }

