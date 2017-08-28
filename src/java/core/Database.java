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
 * @author Proyecto rubrica
 */
public class Database {
    //PROPIEDADES

    private static final String DB_NAME = "dummy";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "";
    private static final String DB_HOST = "localhost:3306";
    private static Database instance;
    private Connection conn;
    private Statement stm;

    /**
     * El constructor de la clase hace la conexion a la base de datos.
     *
     * @throws Exception Si no se puede conectar a la base de datos se lanza un
     * excepción.
     */
    //CONSTRUCTOR
    private Database() throws Exception
    {
        //Class.forName("org.mariadb.jdbc.Driver").newInstance();
        Class.forName("com.mysql.jdbc.Driver").newInstance();
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
    
    public static Database getInstance() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, Exception
    {
        //if(instance == null)
        //{
            instance = new Database();
        //}
        
        return instance;
    }
    
}