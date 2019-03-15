/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udem.edu.com.co.importdata;

import com.opencsv.CSVReader; //Esta libreria es gestionada con Maven
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 * Esta clase se usa como manejador para importar los datos del documento CSV
 * al servidor Derby
 * 
 */
public class Importar {
    
    private char separator;
    private char quote;
    
    public Importar() {
        separator = ';';
        quote = '"';
    }
    
    //Este metodo es usado para cargar el documento csv que contiene los paquetes
    public void importarPaquetes(String dir) {


        CSVReader reader = null;
        PreparedStatement pstm = null;

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = (Connection) DriverManager.getConnection(dir, "app", "app");
            con.setAutoCommit(false);
            reader = new CSVReader(new FileReader("src//main//resources//tablas//PAQUETES.csv"), separator, quote);
            String[] data;
            int i = 0;
            System.out.println("Importando paquetes");
            while ((data = reader.readNext()) != null) {

                int id = Integer.parseInt(data[0]);
                String fechare = data[1];
                String fechaes = data[2];
                String ciudador = data[3];
                String ciudaddes = data[4];
                String direccion = data[5];
                String destina = data[6];
                String estado = data[7];
                int idencar = Integer.parseInt(data[8]);
                String sql = "INSERT INTO PAQUETES VALUES(" + id + ",'" + fechare + "','" + fechaes
                        + "','" + ciudador + "','" + ciudaddes + "','" + direccion + "','" + destina + "','" + estado + "'," + idencar + ")";
                pstm = (PreparedStatement) con.prepareStatement(sql);
                pstm.execute();
                System.out.println("Importando fila: " + i);
                i++;
            }
            con.commit();
        } catch (SQLException | ClassNotFoundException | IOException ex) {
            System.out.println(ex);

        }finally {

            try {
                pstm.close();
                reader.close();
            } catch (SQLException | IOException ex) {
                System.out.println(ex);
            }
            
        }

    }
    
    //Este metodo es usado para cargar el documento csv que contiene los usuarios
    public void importarUsuarios(String dir) {

        
        CSVReader reader = null;
        PreparedStatement pstm = null;

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = (Connection) DriverManager.getConnection(dir, "app", "app");
            con.setAutoCommit(false);
            reader = new CSVReader(new FileReader("src//main//resources//tablas//USUARIOS.csv"), separator, quote);
            String[] data;
            int i = 0;
            System.out.println("Importando usuarios");
            while ((data = reader.readNext()) != null) {

                int id = Integer.parseInt(data[0]);
                String user = data[1];
                String pass = data[2];
                String rol = data[3];
                String sql = "INSERT INTO USERS VALUES(" + id + ",'" + user + "','" + pass
                            + "','" + rol + "')";

                pstm = (PreparedStatement) con.prepareStatement(sql);
                pstm.execute();
                System.out.println("Importando fila: " + i);
                i++;
            }
            con.commit();
        } catch (SQLException | ClassNotFoundException | IOException ex) {
            System.out.println(ex);

        }finally {

            try {
                pstm.close();
                reader.close();
            } catch (SQLException | IOException ex) {
                System.out.println(ex);
            }
            
        }  
                

    }

    public char getSeparator() {
        return separator;
    }

    public void setSeparator(char separator) {
        this.separator = separator;
    }

    public char getQuote() {
        return quote;
    }

    public void setQuote(char quote) {
        this.quote = quote;
    }

}
