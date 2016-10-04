package test;

import java.util.HashMap;
import javax.persistence.Persistence;

/**
 *
 * @author emmablomsterberg
 */
public class SchemaBuilder {
    
    public static void main(String[] args) {
        
//        
        HashMap<String, Object> puproperties = new HashMap();
//        HashMap<String, Object> puproperties1 = new HashMap();
//        
        puproperties.put("javax.persistence.sql-load-script-source", "scripts/ClearDB.sql"); 
//        puproperties.put("javax.persistence.sql-load-script-source", "scripts/populateZip.sql"); 
//        puproperties.put("javax.persistence.sql-load-script-source", "scripts/Populate.sql");
//        
////        System.out.println(puproperties.get("javax.persistence.sql-load-script-source"));
//
        Persistence.generateSchema("PU_CA2", puproperties);
//        //Persistence.generateSchema("PU_CA2", puproperties1);
//        
        Persistence.generateSchema("PU_CA2", null);
        
    }
}
