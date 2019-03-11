/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package importdata;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;

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
            FileInputStream input;
            try (Connection con = (Connection) DriverManager.getConnection(dir, "app", "app")) {
                con.setAutoCommit(false);
                PreparedStatement pstm = null;
                input = new FileInputStream("src//resources/PAQUETES.xls");
                POIFSFileSystem fs = new POIFSFileSystem(input);
                HSSFWorkbook wb = new HSSFWorkbook(fs);
                HSSFSheet sheet = wb.getSheetAt(0);
                Row row;
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                    row = sheet.getRow(i);
                    int id = (int) row.getCell(0).getNumericCellValue();
                    Date datfechare = row.getCell(1).getDateCellValue();
                    String fechare = sdf.format(datfechare);
                    Date datfechaes = row.getCell(2).getDateCellValue();
                    String fechaes = sdf.format(datfechaes);
                    String ciudador = row.getCell(3).getStringCellValue();
                    String ciudaddes = row.getCell(4).getStringCellValue();
                    String direccion = row.getCell(5).getStringCellValue();
                    String destina = row.getCell(6).getStringCellValue();
                    String estado = row.getCell(7).getStringCellValue();
                    int idencar = (int) row.getCell(8).getNumericCellValue();
                    String sql = "INSERT INTO PAQUETES VALUES(" + id + ",'" + fechare + "','" + fechaes
                            + "','" + ciudador + "','" + ciudaddes + "','" + direccion + "','" + destina + "','" + estado + "'," + idencar + ")";
                    pstm = (PreparedStatement) con.prepareStatement(sql);
                    pstm.execute();
                    System.out.println("Importando fila: " + i);
                }
                con.commit();
                pstm.close();
            }
            input.close();
            System.out.println("Importar de Excel a SQL terminado");
        } catch (ClassNotFoundException | SQLException | IOException e) {
            System.out.println(e);
        }

    }

    public void ImportarUsuarios(String dir) {

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            FileInputStream input;
            try (Connection con = (Connection) DriverManager.getConnection(dir, "app", "app")) {
                con.setAutoCommit(false);
                PreparedStatement pstm = null;
                input = new FileInputStream("src//resources/USUARIOS.xls");
                POIFSFileSystem fs = new POIFSFileSystem(input);
                HSSFWorkbook wb = new HSSFWorkbook(fs);
                HSSFSheet sheet = wb.getSheetAt(0);
                Row row;
                for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                    row = sheet.getRow(i);
                    int id = (int) row.getCell(0).getNumericCellValue();
                    String user = row.getCell(1).getStringCellValue();
                    String pass = row.getCell(2).getStringCellValue();
                    String rol = row.getCell(3).getStringCellValue();
                    String sql = "INSERT INTO USERS VALUES(" + id + ",'" + user + "','" + pass
                            + "','" + rol + "')";
                    pstm = (PreparedStatement) con.prepareStatement(sql);
                    pstm.execute();
                    System.out.println("Importando fila: " + i);
                }
                con.commit();
                pstm.close();
            }
            input.close();
            System.out.println("Importar de Excel a SQL terminado");
        } catch (ClassNotFoundException | SQLException | IOException e) {
            System.out.println(e);
        }

    }

}