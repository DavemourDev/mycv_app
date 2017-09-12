/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import core.Database;
import java.sql.ResultSet;

/**
 *
 * @author mati
 */
public class DatabaseUtils 
{
    private DatabaseUtils(){};
    
    /**
     * Devuelve todos los registros de una tabla de la base de datos.
     * 
     * Puede usarse también con vistas, y del mismo modo todos los métodos de este tipo.
     * 
     * @param table Nombre de la tabla en la base de datos.
     * @return ResultSet con todos los registros de la tabla.
     */
    public static ResultSet selectAll(String table)
    {
        ResultSet rs = null;
        
        try
        {
            rs = Database.getInstance().query("select * from `" + table + "`;"); 
        }
        catch(Exception ex)
        {
            System.err.println("Error con la base de datos....");
        }
        
        return rs;
    }
  
    /**
     * Ver implementación con String como value.
     * */
    public static ResultSet selectAllWhere(String table, String attr, int value)
    {
        return selectAllWhere(table, attr, String.valueOf(value));
    }
    
    /**
     * Ver implementación con String como value.
     * */
    public static ResultSet selectAllWhere(String table, String attr, double value)
    {
        return selectAllWhere(table, attr, String.valueOf(value));
    }
    
    /**
     * Ver implementación con String como value.
     * */
    public static ResultSet selectAllWhere(String table, String attr, boolean value)
    {
        return selectAllWhere(table, attr, String.valueOf(value));
    }
            
    /**
     * Devuelve todos los registros de una tabla que cumplan un requisito.
     * 
     * @param table Nombre de la tabla en la base de datos.
     * @param attr Nombre del campo a filtrar
     * @param value Valor a filtrar
     * @return ResultSet con todos los resultados que cumplan el requisito.
     */
    public static ResultSet selectAllWhere(String table, String attr, String value)
    {
        ResultSet rs = null;
        
        try
        {
            rs = Database.getInstance().query("select * from `" + table + "` where `" + attr + "`='" + value + "';"); 
        
        }
        catch(Exception ex)
        {
            System.err.println("Error con la base de datos....");
        }
        
        return rs;
        
    }
    
    /**
     * Obtiene un set de resultados (de un único resultado) de una tabla, resultante
     * de búsqueda por id.
     * 
     * @param table Nombre de la tabla en la base de datos.
     * @param id Valor de id del registro buscado.
     * @return ResultSet con el resultado buscado, o ResultSet vacío en caso de que no
     * existiera.
     */
    public static ResultSet selectById(String table, int id)
    {
        ResultSet rs = null;
        
        try
        {
            rs = Database.getInstance().query("select * from `" + table + "` where `id`=" + String.valueOf(id) +";"); 
        }
        catch(Exception ex)
        {
            System.err.println("Error con la base de datos....");
        }
        
        return rs;
        
    }
    
    /**
     * Inicia una transacción en la base de datos. 
     * Todas las sentencias ejecutadas en una transacción solamente tendrán 
     * efecto definitivo una vez se confirme la misma.
     */
    public static void startTransaction()
    {
        try
        {
            Database.getInstance().query("start transaction;");
    
        }
        catch(Exception ex)
        {
            System.err.println("Error con la base de datos.... (start transaction)");
        }
    }
    
    /**
     * Confirma una transaccción en la base de datos.
     * Al confirmar una transacción se pone fin y los cambios son irreversibles.
     */
    public static void commitTransaction()
    {
        try
        {
            Database.getInstance().query("commit;");
    
        }
        catch(Exception ex)
        {
            System.err.println("Error con la base de datos.... (commit)");
        }
    }
    
    /**
     * Cancela la transacción actual en la base de datos.
     * Todas las instrucciones ejecutadas en una transacción al cancelarse quedan
     * anuladas.
     */
    public static void cancelTransaction()
    {
        try
        {
            Database.getInstance().query("rollback;");
    
        }
        catch(Exception ex)
        {
            System.err.println("Error con la base de datos.... (rollback)");
        }
    }
    
}
