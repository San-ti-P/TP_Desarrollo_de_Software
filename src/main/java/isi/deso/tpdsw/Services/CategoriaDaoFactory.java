package isi.deso.tpdsw.Services;

import isi.deso.tpdsw.Daos.CategoriaDao;
import isi.deso.tpdsw.Daos.CategoriaMemory;
import isi.deso.tpdsw.Daos.CategoriaSQL;
import java.util.TreeMap;

public class CategoriaDaoFactory {
    private final TreeMap<String, Integer> tipos = new TreeMap();

    public CategoriaDaoFactory(){
        tipos.put("memory", 0);
        tipos.put("sql", 1);
    }

    public CategoriaDao getDao(String tipo){
        String t = tipo.toLowerCase();
        switch(tipos.get(t)){
            case 0 -> {
                return new CategoriaMemory();
            }
            case 1 -> {
                return new CategoriaSQL();
            }
        }
        return null;
    }
}

