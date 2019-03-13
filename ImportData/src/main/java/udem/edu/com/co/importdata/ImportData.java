/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udem.edu.com.co.importdata;

/**
 *
 * @author ASUS
 */
public class ImportData {
    
    public static void main(String[] args) {
        
        Importar imp = new Importar();
        imp.ImportarPaquetes("jdbc:derby://localhost:1527/RecogidasDB");
        imp.ImportarUsuarios("jdbc:derby://localhost:1527/RecogidasDB");
    }
    
}
