package ex22_baserelacionale;

import com.sun.xml.internal.bind.v2.TODO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ex22_baserelacionalE {

    Connection conn;

    public void Conexion() throws SQLException {

        String driver = "jdbc:oracle:thin:";
        String host = "localhost.localdomain"; // tambien puede ser una ip como "192.168.1.14"
        String porto = "1521";
        String sid = "orcl";
        String usuario = "hr";
        String password = "hr";
        String url = driver + usuario + "/" + password + "@" + host + ":" + porto + ":" + sid;

        conn = DriverManager.getConnection(url);

    }

    public void Cerrar() throws SQLException {

        conn.close();

    }

    ArrayList<TODO> contenidoTabla = new ArrayList<>();

    public void obtenerMetadata() {

        try {
            PreparedStatement pst = conn.prepareStatement("select produtos.* from produtos");
            ResultSetMetaData rsmd = pst.getMetaData();
            
            int numcolum  = rsmd.getColumnCount();
            
            //solo nos pide el nombre de las columnas !
            for(int i = 1; i< numcolum;i++){
                
                if(rsmd.getColumnType(i) == Types.VARCHAR){
                    
                   
                    
                }
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(Ex22_baserelacionalE.class.getName()).log(Level.SEVERE, null, ex);
        }

        

    }

    public static void main(String[] args) {

        Ex22_baserelacionalE obj = new Ex22_baserelacionalE();

    }

}
