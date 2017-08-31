package core;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Clase que sirve para hacer la conexion a la base de datos y los metodos para
 * trabajar con ella.
 *
 * @author David
 */
public class Database {
    //PROPIEDADES

    private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
    private static final String DB_NAME = "cv_db";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "root";
    private static final String DB_HOST = "localhost:3306";
    private static Database instance;
    private Connection conn;
    private Statement stm;

    /**
     * El constructor de la clase instancia el Driver.
     *
     * @throws Exception Si la clase del driver no ha podido encontrarse (Normalmente porque no se haya cargado el .jar del conector).
     */
    //CONSTRUCTOR
    private Database() throws Exception
    {
        //Class.forName("org.mariadb.jdbc.Driver").newInstance();
        Class.forName(DRIVER_CLASS).newInstance();
    }

    private void connect() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException
    {
        this.conn = DriverManager.getConnection("jdbc:mysql://" + DB_HOST + "/" + DB_NAME, DB_USER, DB_PASS);
        this.stm = conn.createStatement();
        System.out.println("Conexión establecida");
    }
    
    /**
     * Metodo para desconectar de la base de datos.
     *
     * @throws Exception
     */
    private void close() throws Exception 
    {
        
        if(!this.conn.isClosed())
        {
            this.conn.close();
        }
    }

    /**
     * Abre la conexión a la base de datos para realizar una consulta y después la cierra.
     * Se usa cuando se quieren obtener datos de la base de datos.
     * @param q String Consulta SQL
     * @return ResultSet con los resultados de la consulta
     * @throws Exception 
     */
    public ResultSet query(String q) throws Exception
    {
        this.connect();
        ResultSet rs = this.stm.executeQuery(q);
        //this.close();
        return rs;
    }
    
    /**
     * Abre la conexión a la base de datos para realizar una consulta y después la cierra.
     * 
     * Se usa cuando se quieren insertar datos en la base de datos.
     * No usar para sentencias de obtención de datos.
     * 
     * @param q String Consulta SQL
     * @return int Número de registros insertados/afectados.
     * @throws Exception 
     */
    public int queryUpdate(String q) throws Exception
    {
        this.connect();
        //ResultSet rs = this.stm.executeQuery(q);
        //this.close();
        return this.stm.executeUpdate(q);
    }
    
    public static Database getInstance() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, Exception
    {
        //if(instance == null)
        //{
            instance = new Database();
        //}
        
        return instance;
    }
    
}