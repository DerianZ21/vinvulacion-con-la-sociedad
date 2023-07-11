package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author pc
 */
public class Conexion {
    public Connection conexion;
    
    static String usuario = "postgres";
    static String contrasena = "d123456";

    static String base = "PruebaBuenPastorDB";
//    static String base = "dbr_buenpastorB";
    static String cadenaConexion = "jdbc:postgresql://127.0.0.1/"+base+"?"+ "user="+usuario+"&password="+contrasena;
    //private Statement sentencia = null;
    
//    public Statement sta() throws SQLException {
//        sentencia = conexion.createStatement();
//        return sentencia;
//    }
    
    public Conexion() {
    }
    
    public Conexion(Connection con) {
        this.conexion = con;
    }
    
    public Connection getCon() {
        return conexion;
    }
    
    public void setCon(Connection con) {
        this.conexion = con;
    }
    public Connection conectar() throws ClassNotFoundException, Exception{
        Class.forName("org.postgresql.Driver");
        conexion = DriverManager.getConnection(cadenaConexion);
        return conexion;
    }
    
    public void desconectar() throws Exception{
        try {
            if(conexion!=null){
                if(conexion.isClosed()==false){
                    conexion.close();
                }
            }
        } catch (SQLException e) {
            throw e;
        }
    }
    
}
