package importdata;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


public class ImportData {

    /**
     * @param args
     */
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            FileInputStream input;
            try (Connection con = (Connection) DriverManager.getConnection("jdbc:derby://localhost:1527/RecogidasDB","app","app")) {
                con.setAutoCommit(false);
                PreparedStatement pstm = null ;
                input = new FileInputStream("D://file.xls");
                POIFSFileSystem fs = new POIFSFileSystem( input );
                HSSFWorkbook wb = new HSSFWorkbook(fs);
                HSSFSheet sheet = wb.getSheetAt(0);
                Row row;
                for(int i=1; i<=sheet.getLastRowNum(); i++){
                    row = sheet.getRow(i);
                    int id = (int) row.getCell(0).getNumericCellValue();
                    String name = row.getCell(1).getStringCellValue();
                    String address = row.getCell(2).getStringCellValue();
                    String sql = "INSERT INTO PAQUETES VALUES('"+id+"','"+name+"','"+address+"')";
                    pstm = (PreparedStatement) con.prepareStatement(sql);
                    pstm.execute();
                    System.out.println("Import rows "+i);
                }   con.commit();
                pstm.close();
            }
            input.close();
            System.out.println("Success import excel to mysql table");
        }catch(ClassNotFoundException | SQLException | IOException e){
            System.out.println(e);
        }

    }

}