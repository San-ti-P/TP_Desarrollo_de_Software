package isi.deso.tpdsw.Services;

import isi.deso.tpdsw.Daos.PlatoDao;
import isi.deso.tpdsw.Daos.PlatoMemory;
import isi.deso.tpdsw.Daos.PlatoSQL;
import java.util.TreeMap;

public class PlatoDaoFactory {
    private final TreeMap<String, Integer> tipos = new TreeMap();
    
    public PlatoDaoFactory(){
        tipos.put("memory", 0);
        tipos.put("sql", 1);
    }
   
    public PlatoDao getDao(String tipo){
        String t = tipo.toLowerCase();
        switch(tipos.get(t)){
            case 0 -> {
                return new PlatoMemory();
            }
            case 1 -> {   
                return new PlatoSQL();
            }
        }
        return null;
    }
}
