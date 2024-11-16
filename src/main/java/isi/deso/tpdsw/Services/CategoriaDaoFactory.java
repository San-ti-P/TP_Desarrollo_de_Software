package isi.deso.tpdsw.Services;

import isi.deso.tpdsw.Daos.CategoriaDao;
import isi.deso.tpdsw.Daos.CategoriaMemory;
import isi.deso.tpdsw.Daos.CategoriaSQL;
import java.util.TreeMap;

public class CategoriaDaoFactory {
    private static CategoriaSQL SQL_INSTANCE;
    private static CategoriaMemory MEMORY_INSTANCE;
    
    private static CategoriaSQL getSQLInstance(){
        if(SQL_INSTANCE == null) {
            SQL_INSTANCE = new CategoriaSQL();
        }
        return SQL_INSTANCE;
    }
    
    private static CategoriaMemory getMemoryInstance(){
        if(MEMORY_INSTANCE == null) {
            MEMORY_INSTANCE = new CategoriaMemory();
        }
        return MEMORY_INSTANCE;
    }
    
    private final TreeMap<String, Integer> tipos = new TreeMap();
    
    public CategoriaDaoFactory(){
        tipos.put("memory", 0);
        tipos.put("sql", 1);
    }
   
    public CategoriaDao getDao(String tipo){
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
