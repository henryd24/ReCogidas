package importdata;


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