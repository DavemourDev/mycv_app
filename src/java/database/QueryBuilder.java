package database;

import config.Config;
import helpers.FormatUtils;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class QueryBuilder
{

    public String operation;
    public String table;
    public List<String> fields = new ArrayList<>();
    public List<String> values = new ArrayList<>();
    public LinkedHashMap<String, String> where = new LinkedHashMap<>();
    public List<String> whereOperation = new ArrayList<>();
    public String orderField;
    public String orderDirection;
    
    public QueryBuilder select(String table)
    {
        this.operation = "select";
        this.table = table;
        
        return this;
    }

    public QueryBuilder insert()
    {
        this.operation = "insert";
        return this;
    }

    public QueryBuilder update(String table)
    {
        this.operation = "update";
        this.table = table;
        return this;
    }

    public QueryBuilder delete(String table)
    {
        this.table = table;
        this.operation = "delete";
        return this;
    }

    public QueryBuilder where(String key, String value)
    {
        this.where.put(key, value);
        return this;
    }

    public QueryBuilder where(String key, int value)
    {
        return this.where(key, String.valueOf(value));
    }

    public QueryBuilder and(String key, String value)
    {
        if (!this.where.isEmpty())
        {
            this.where.put(key, value);
            this.whereOperation.add("and");
        }
        return this;
    }

    public QueryBuilder and(String key, int value)
    {
        return this.and(key, String.valueOf(value));
    }
    
    public QueryBuilder or(String key, String value)
    {
        if (!this.where.isEmpty())
        {
            this.where.put(key, value);
            this.whereOperation.add("or");
        }
        return this;
    }
    
    public QueryBuilder or(String key, int value)
    {
        return this.or(key, String.valueOf(value));
    }
    
    public QueryBuilder orderBy(String order, boolean desc)
    {
        this.orderField = order;
        this.orderDirection = desc ? "desc" : "asc";

        return this;
    }

    public QueryBuilder orderBy(String order)
    {
        return this.orderBy(order, false);
    }

    public QueryBuilder insertInto(String table)
    {
        this.operation = "insert";
        this.table = table;
        
        return this;
    }
    
    public QueryBuilder fields(Object... fields)
    {
        for(Object obj : fields)
        {
            this.fields.add(obj.toString());
        }
        return this;
    }
    public QueryBuilder values(Object... values)
    {
        for(Object obj : values)
        {
            this.values.add(obj.toString());
        }
        return this;
    }
    
    private void parseWhere(StringBuilder sb)
    {
        if (!this.where.isEmpty())
        {
            sb.append(" where ");
            int i = 0;
            Object[] keys = this.where.keySet().toArray();
            int size = keys.length;

            while (true)
            {
                String key = (String) keys[i++];
                String value = this.where.get(key);

                sb.append(FormatUtils.surroundWith(key, '`'));
                sb.append('=');
                if(key.equalsIgnoreCase("password"))
                {
                    sb.append(Config.PASSWORD_ENCRYPT_FUNCTION).append(FormatUtils.surroundWithParenthesis(FormatUtils.surroundWith(value, '\'')));
                }
                else
                {
                    sb.append(FormatUtils.surroundWith(value, '\''));
                }

                if (i == size)
                {
                    break;
                }
                sb.append(FormatUtils.surroundWith(this.whereOperation.get(i - 1), ' '));
            }
        }
    }
    
    private void buildSelect(StringBuilder sb)
    {
        sb.append("select ");
        if (this.fields.isEmpty())
        {
            sb.append('*');
        } 
        else
        {
            int i = 0;
            while (true)
            {
                
                sb.append(FormatUtils.surroundWith(this.fields.get(i++), '`'));
                if (i == this.fields.size())
                {
                    break;
                }
                sb.append(", ");
            }
        }

        if (this.table != null)
        {
            sb.append(" from ").append(FormatUtils.surroundWith(this.table, '`'));
        }

        parseWhere(sb);
        
        if(this.orderField != null && orderDirection != null)
        {
            sb.append(" order by")
                .append(FormatUtils.surroundWith(FormatUtils.surroundWith(orderField, '`'), ' '))
                .append(this.orderDirection);
        }
        
    }

    private void buildInsert(StringBuilder sb)
    {
        if(this.fields.size() != this.values.size())
        {
            return;
            //throw new Exception("Tamaño de lista de campos difiere de tamaño de lista de valores");
        }
        if(this.fields.isEmpty())
        {
            return;
            //throw new Exception("Lista de campos vacía. Debe contener al menos un elemento.");
        }
        
        int i = 0;
        int size = this.fields.size();
        
        sb.append("insert into ")
                .append(FormatUtils.surroundWith(this.table, '`'));
    
        StringBuilder f = new StringBuilder();
        StringBuilder v = new StringBuilder();
        
        while(true)
        {
            f.append(FormatUtils.surroundWith(this.fields.get(i), '`'));
           
            if(this.fields.get(i).equalsIgnoreCase("password"))
            {
                v.append(Config.PASSWORD_ENCRYPT_FUNCTION).append(FormatUtils.surroundWithParenthesis(FormatUtils.surroundWith(this.values.get(i), '\'')));
            }
            else
            {
                v.append(FormatUtils.surroundWith(this.values.get(i), '\''));
            }

           if(++i == size)
           {
               break;
           }
           f.append(',');
           v.append(',');
        }
        
        sb.append(FormatUtils.surroundWithParenthesis(f.toString()))
            .append(" values ")
            .append(FormatUtils.surroundWithParenthesis(v.toString()));
    }
    
    private void buildUpdate(StringBuilder sb)
    {
        if(this.fields.size() != this.values.size())
        {
            return;
            //throw new Exception("Tamaño de lista de campos difiere de tamaño de lista de valores");
        }
        if(this.fields.isEmpty())
        {
            return;
            //throw new Exception("Lista de campos vacía. Debe contener al menos un elemento.");
        }
        
        int i = 0;
        int size = this.fields.size();
        
        sb.append("update ")
            .append(FormatUtils.surroundWith(this.table, '`'))
            .append(" set ");
    
        while (true)
        {
            sb.append(FormatUtils.surroundWith(this.fields.get(i), '`'))
                .append('=');
                    
                if(this.fields.get(i).equalsIgnoreCase("password"))
                {
                    sb.append(Config.PASSWORD_ENCRYPT_FUNCTION).append(FormatUtils.surroundWithParenthesis(FormatUtils.surroundWith(this.values.get(i), '\'')));
                }
                else
                {
                    sb.append(FormatUtils.surroundWith(this.values.get(i), '\''));
                }

            if (++i == size)
            {
                break;
            }
            sb.append(',');
        }

        parseWhere(sb);
    }
    
    private void buildDelete(StringBuilder sb)
    {
        sb.append("delete from ")
            .append(FormatUtils.surroundWith(this.table, '`'));
          
        parseWhere(sb);
    }
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        switch (this.operation)
        {
            case "select":
                this.buildSelect(sb);
                break;
            case "insert":
                this.buildInsert(sb);
                break;
            case "update":
                this.buildUpdate(sb);
                break;
            case "delete":
                this.buildDelete(sb);
                break;
            default:
                break;
        }

        sb.append(';');
        return sb.toString();
    }
    
    
}
