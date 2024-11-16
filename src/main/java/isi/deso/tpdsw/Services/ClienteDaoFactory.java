package isi.deso.tpdsw.Services;

import isi.deso.tpdsw.Daos.ClienteDao;
import isi.deso.tpdsw.Daos.ClienteMemory;
import isi.deso.tpdsw.Daos.ClienteSQL;
import java.util.TreeMap;

public class ClienteDaoFactory {
    private static ClienteSQL SQL_INSTANCE;
    private static ClienteMemory MEMORY_INSTANCE;

    private static ClienteSQL getSQLInstance(){
        if(SQL_INSTANCE == null) {
            SQL_INSTANCE = new ClienteSQL();
        }
        return SQL_INSTANCE;
    }

    private static ClienteMemory getMemoryInstance(){
        if(MEMORY_INSTANCE == null) {
            MEMORY_INSTANCE = new ClienteMemory();
        }
        return MEMORY_INSTANCE;
    }

    private final TreeMap<String, Integer> tipos = new TreeMap<>();

    public ClienteDaoFactory(){
        tipos.put("memory", 0);
        tipos.put("sql", 1);
    }

    public ClienteDao getDao(String tipo){
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