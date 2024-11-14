
package isi.deso.tpdsw.Services;

import isi.deso.tpdsw.Daos.VendedorDao;
import isi.deso.tpdsw.Daos.VendedorMemory;
import isi.deso.tpdsw.Daos.VendedorSQL;
import java.util.TreeMap;

public class VendedorDaoFactory {
    private final TreeMap<String, Integer> tipos = new TreeMap();
    
    public VendedorDaoFactory(){
        tipos.put("memory", 0);
        tipos.put("sql", 1);
    }
   
    public VendedorDao getDao(String tipo){
        String t = tipo.toLowerCase();
        switch(tipos.get(t)){
            case 0 -> {
                return new VendedorMemory();
            }
            case 1 -> {   
                return new VendedorSQL();
            }
        }
        return null;
    }
}
