/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import database.Database;
import database.QueryBuilder;
import java.sql.ResultSet;
import java.util.HashMap;

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
            QueryBuilder query = new QueryBuilder()
                    .select(table);
                    
            
            rs = Database.getInstance().query(query); 
        }
        catch(Exception ex)
        {
            System.err.println("Error con la base de datos....");
        }
        
        return rs;
    }
  
    /**
     * Ver implementación con String como value.
     *
     * @param table
     * @param attr
     * @param value
     * @return  */
    public static ResultSet selectAllWhere(String table, String attr, int value)
    {
        return selectAllWhere(table, attr, String.valueOf(value));
    }
    
    /**
     * Ver implementación con String como value.
     *
     * @param table
     * @param attr
     * @param value
     * @return  
     */
    public static ResultSet selectAllWhere(String table, String attr, double value)
    {
        return selectAllWhere(table, attr, String.valueOf(value));
    }
    
    /**
     * Ver implementación con String como value.
     *
     * @param table
     * @param attr
     * @param value
     * @return  
     */
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
            QueryBuilder query = new QueryBuilder()
                    .select(table)
                    .where(attr, value);
            
            rs = Database.getInstance().query(query);
            
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
            QueryBuilder query = new QueryBuilder()
                    .select(table)
                    .where("id", id);
            
            rs = Database.getInstance().query(query);
        }
        catch(Exception ex)
        {
            System.err.println("Error con la base de datos....");
        }
        
        return rs;
        
    }
    
    
    /**
     * Inserta un registro en la tabla indicada con los campos y valores incluidos en el
     * HashMap.
     * 
     * Devuelve true si al menos se ha logrado insertar un registro.
     * 
     * @param table
     * @param params
     * @return
     * @throws Exception 
     */
    public static boolean insert(String table, HashMap<String, String> params) throws Exception
    {
        
        try
        {
            QueryBuilder query = new QueryBuilder()
                    .insertInto(table)
                    .fields(params.keySet().toArray())
                    .values(params.values().toArray());
            
            return Database.getInstance().queryUpdate(query) > 0;
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
    /**
     * Actualiza un registro de la base de datos. 
     * Es necesario incluir una referencia a la clave primaria en los parámetros.
     * Si no se incluye, siempre se devolverá false.
     * 
     * @param table
     * @param params
     * @return
     * @throws Exception 
     */
    public static boolean update(String table, HashMap<String, String> params) throws Exception
    {
        try
        {
            QueryBuilder query = new QueryBuilder()
                    .update(table)
                    .fields(params.keySet().toArray())
                    .values(params.values().toArray())
                    .where("id", params.get("id"));
            
            return Database.getInstance().queryUpdate(query) > 0;
        }
        catch(Exception ex)
        {
            throw ex;
        }
    }
    
    /**
     * Elimina el registro de la tabla indicada con el id indicado.
     * Devuelve true si se ha eliminado con éxito al menos un registro.
     * @param table
     * @param id
     * @return
     * @throws Exception 
     */
    public static boolean deleteById(String table, int id) throws Exception
    {
        QueryBuilder query = new QueryBuilder()
                .delete(table)
                .where("id", id);
                
        return Database.getInstance().queryUpdate(query) > 0;
    }
    
    /**
     * Obtiene la id del último registro insertado en la tabla.
     * NOTA: En realidad devuelve la id más alta, pero para la base de datos utilizada,
     *       el último elemento insertado siempre tiene la id más alta.
     * 
     * @param table
     * @return
     * @throws Exception 
     */
    public static int getLastId(String table) throws Exception
    {
        QueryBuilder query = new QueryBuilder()
                .select(table)
                .fields("id")
                .orderBy("id", true);
        
        ResultSet rs = Database.getInstance().query(query);
        rs.next();
        System.out.println(rs.getInt("id"));
        
        return rs.getInt("id");
    }
    
    public static ResultSet getUserRegister(String email, String password) throws Exception
    {
        QueryBuilder query = new QueryBuilder()
                .select("user")
                .where("email", email)
                .and("password", password);
        
        return Database.getInstance().query(query);
    }
    
}
