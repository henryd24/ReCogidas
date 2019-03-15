/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udem.edu.com.co.importdata;

/**
 *
 * @author ASUS
 * Clase principal del proyecto para importar al servidor Derby
 */
public class ImportData {
    
    public static void main(String[] args) {
        
        Importar imp = new Importar(); //Se crea una instancia de la clase importar para acceder a sus metodos
        imp.ImportarPaquetes("jdbc:derby://localhost:1527/RecogidasDB");  //Se debe modificar la dirección dependiendo
        imp.ImportarUsuarios("jdbc:derby://localhost:1527/RecogidasDB");   //donde de donde corra el servidor
        
    }
    
}
