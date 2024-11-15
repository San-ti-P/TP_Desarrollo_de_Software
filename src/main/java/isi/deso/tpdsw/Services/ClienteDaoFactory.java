package isi.deso.tpdsw.Services;

import isi.deso.tpdsw.Daos.ClienteDao;
import isi.deso.tpdsw.Daos.ClienteMemory;
import isi.deso.tpdsw.Daos.ClienteSQL;

import java.util.TreeMap;

public class ClienteDaoFactory {
    private final TreeMap<String, Integer> tipos = new TreeMap<>();

    public ClienteDaoFactory(){
        tipos.put("memory", 0);
        tipos.put("sql", 1);
    }

    public ClienteDao getDao(String tipo){
        String t = tipo.toLowerCase();
        switch(tipos.get(t)){
            case 0 -> {
                return new ClienteMemory();
            }
            case 1 -> {
                return new ClienteSQL();
            }
        }
        return null;
    }
}