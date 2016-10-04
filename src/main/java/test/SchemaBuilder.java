package test;

import javax.persistence.Persistence;

/**
 *
 * @author emmablomsterberg
 */
public class SchemaBuilder {
    
    public static void main(String[] args) {
        
        Persistence.generateSchema("PU_CA2", null);
        
    }
}
