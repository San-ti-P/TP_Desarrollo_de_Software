package isi.deso.tpdsw.Services;

import isi.deso.tpdsw.Daos.BebidaDao;
import isi.deso.tpdsw.Daos.BebidaMemory;
import isi.deso.tpdsw.Daos.BebidaSQL;
import java.util.TreeMap;

public class BebidaDaoFactory {
    private final TreeMap<String, Integer> tipos = new TreeMap();

    public BebidaDaoFactory(){
        tipos.put("memory", 0);
        tipos.put("sql", 1);
    }

    public BebidaDao getDao(String tipo){
        String t = tipo.toLowerCase();
        switch(tipos.get(t)){
            case 0 -> {
                return new BebidaMemory();
            }
            case 1 -> {
                return new BebidaSQL();
            }
        }
        return null;
    }
}
