package test;

import java.util.HashMap;
import javax.persistence.Persistence;

/**
 *
 * @author emmablomsterberg
 */
public class SchemaBuilder {
    
    public static void main(String[] args) {
        
        HashMap<String, Object> puproperties = new HashMap();
      
        puproperties.put("javax.persistence.sql-load-script-source", "scripts/ClearDB.sql"); 
       
        Persistence.generateSchema("PU_CA2", puproperties);
        Persistence.generateSchema("PU_CA2", null);
        
    }
}
