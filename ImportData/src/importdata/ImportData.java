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


public class ImportData {

    /**
     * @param args
     */
    public static void main(String[] args) {
        
        Importar imp = new Importar();
        
        imp.ImportarPaquetes("jdbc:derby://localhost:1527/RecogidasDB");
        imp.ImportarUsuarios("jdbc:derby://localhost:1527/RecogidasDB");

    }

}