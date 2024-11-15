
package isi.deso.tpdsw.Services;

import isi.deso.tpdsw.Daos.VendedorDao;
import isi.deso.tpdsw.Daos.VendedorMemory;
import isi.deso.tpdsw.Daos.VendedorSQL;
import java.util.TreeMap;

public class VendedorDaoFactory {
    private static VendedorSQL SQL_INSTANCE;
    private static VendedorMemory MEMORY_INSTANCE;
    
    private static VendedorSQL getSQLInstance(){
        if(SQL_INSTANCE == null) {
            SQL_INSTANCE = new VendedorSQL();
        }
        return SQL_INSTANCE;
    }
    
    private static VendedorMemory getMemoryInstance(){
        if(MEMORY_INSTANCE == null) {
            MEMORY_INSTANCE = new VendedorMemory();
        }
        return MEMORY_INSTANCE;
    }
    
    private final TreeMap<String, Integer> tipos = new TreeMap();
    
    public VendedorDaoFactory(){
        tipos.put("memory", 0);
        tipos.put("sql", 1);
    }
   
    public VendedorDao getDao(String tipo){
        String t = tipo.toLowerCase();
        switch(tipos.get(t)){
            case 0 -> {
                return getMemoryInstance();
            }
            case 1 -> {   
                return getSQLInstance();
            }
        }
        return null;
    }
}
