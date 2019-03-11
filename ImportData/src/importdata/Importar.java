/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package importdata;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.opencsv.CSVReader;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class Importar {

    public Importar() {
    }

    public void ImportarPaquetes(String dir) {

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            CSVReader reader = new CSVReader(new FileReader("src//resources/PAQUETES.csv"), ',');
            try (Connection con = (Connection) DriverManager.getConnection(dir, "app", "app")) {
                con.setAutoCommit(false);
                PreparedStatement pstm = null;
                String[] rowData;

                int i = 0;
                String[] data;

                while ((rowData = reader.readNext()) != null) {

                    data = rowData[0].split(";");
                    int id = Integer.parseInt(data[0]);
                    String fechare = data[1];
                    System.out.println(fechare);
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
                System.out.println("exit" + i);
                con.commit();
                pstm.close();

            }
            System.out.println("Importar de CSV a SQL terminado");
        } catch (ClassNotFoundException | SQLException | IOException | NumberFormatException e) {
            System.out.println(e);
        }

    }

    public void ImportarUsuarios(String dir) {

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            CSVReader reader = new CSVReader(new FileReader("src//resources/USUARIOS.csv"), ',');
            try (Connection con = (Connection) DriverManager.getConnection(dir, "app", "app")) {
                con.setAutoCommit(false);
                PreparedStatement pstm = null;
                String[] rowData;

                int i = 0;
                String[] data;

                while ((rowData = reader.readNext()) != null) {
                    data = rowData[0].split(";");
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
                pstm.close();

            }
            System.out.println("Importar de CSV a SQL terminado");
        } catch (ClassNotFoundException | SQLException | IOException | NumberFormatException e) {
            System.out.println(e);
        }

    }

}
