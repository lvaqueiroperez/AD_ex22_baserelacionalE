package ex22_baserelacionald;

import com.sun.xml.internal.bind.v2.TODO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ex22_baserelacionalD {

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
            
            for(int i = 1; i< numcolum;i++){
                
                contenidoTabla.add(rsmd.getColumnType(i));
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(Ex22_baserelacionalD.class.getName()).log(Level.SEVERE, null, ex);
        }

        

    }

    public static void main(String[] args) {

        Ex22_baserelacionalD obj = new Ex22_baserelacionalD();

    }

}
